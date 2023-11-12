package com.engineers.plantmanagmementapp.service.containers.impl;

import com.engineers.plantmanagmementapp.errors.PredefinedElementException;
import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.repository.ContainerRepository;
import com.engineers.plantmanagmementapp.security.model.Container;
import com.engineers.plantmanagmementapp.security.model.Plant;
import com.engineers.plantmanagmementapp.service.containers.ContainersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ContainerServiceImpl - Implementation class of container service
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ContainerServiceImpl implements ContainersService {

    private final ContainerRepository containerRepo;

    @Override
    public void addContainer(final Container container, final User owner, final Plantation plantation, final Plant plant) {

    }

    @Override
    public void deleteContainer(final Long id) {
        if (!checkIsPredefined(id)) {
            containerRepo.deleteById(id);
        } else {
            throw new PredefinedElementException("Container with id " + id + " cannot be deleted because it is predefined element.");
        }
    }

    @Override
    public void editContainer(final Container container) {
        if (!checkIsPredefined(container.getId())) {
            final Container editedContainer = containerRepo.findById(container.getId())
                    .orElseThrow();
            editedContainer.setName(container.getName());
            editedContainer.setMaxCapacity(container.getMaxCapacity());
            editedContainer.setCurrentCapacity(container.getCurrentCapacity());
            editedContainer.setCurrentUnit(container.getCurrentUnit());
            containerRepo.save(editedContainer);
        } else {
            throw new PredefinedElementException("Container with id " + container.getId() + " cannot be edited because it is predefined");
        }
    }

    @Override
    public Container getContainerById(final Long id) {
        return null;
    }

    @Override
    public List<Container> getContainers() {
        return null;
    }

    @Override
    public List<Container> getContainersByOwner(final User owner) {
        return null;
    }

    @Override
    public List<Container> getContainersByPlantation(final Plantation plantation) {
        return null;
    }

    private Boolean checkIsPredefined(final Long containerId) {
        return containerRepo.findById(containerId)
                .orElseThrow()
                .getPredefined();
    }
}
