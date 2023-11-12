package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.handler.ContainersHandler;
import com.engineers.plantmanagmementapp.mapper.ContainersMapper;
import com.engineers.plantmanagmementapp.repository.PlantRepository;
import com.engineers.plantmanagmementapp.repository.PlantationRepository;
import com.engineers.plantmanagmementapp.repository.UserRepository;
import com.engineers.plantmanagmementapp.rest.containers.specification.model.ContainerDto;
import com.engineers.plantmanagmementapp.service.containers.ContainersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ContainerHandlerImpl - Implementation class of ContainersHandlerInterface
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ContainersHandlerImpl implements ContainersHandler {

    private final ContainersService containersService;
    private final UserRepository usersRepo;
    private final PlantationRepository plantationRepo;
    private final PlantRepository plantRepo;

    @Override
    public void handleAddContainer(final ContainerDto containerDto) {
        final var owner = usersRepo.findById(containerDto.getOwnerId())
                .orElseThrow();
        final var plantation = plantationRepo.findById(containerDto.getPlantationId())
                .orElseThrow();
        final var plant = plantRepo.findById(containerDto.getPlantId())
                .orElseThrow();
        containersService.addContainer(ContainersMapper.INSTANCE.map(containerDto), owner, plantation, plant);
    }

    @Override
    public void handleDeleteContainer(final Long id) {
        containersService.deleteContainer(id);
    }

    @Override
    public void handleEditContainer(final ContainerDto containerDto) {
        containersService.editContainer(ContainersMapper.INSTANCE.map(containerDto));
    }

    @Override
    public ContainerDto handleGetContainerById(final Long id) {
        return ContainersMapper.INSTANCE.map(containersService.getContainerById(id));
    }

    @Override
    public List<ContainerDto> handleGetContainers() {
        return ContainersMapper.INSTANCE.map(containersService.getContainers());
    }

    @Override
    public List<ContainerDto> handleGetContainersByOwner(final Long ownerId) {
        final var owner = usersRepo.findById(ownerId)
                .orElseThrow();
        return ContainersMapper.INSTANCE.map(containersService.getContainersByOwner(owner));
    }

    @Override
    public List<ContainerDto> handleGetContainersByPlantation(final Long plantationId) {
        final var plantation = plantationRepo.findById(plantationId)
                .orElseThrow();
        return ContainersMapper.INSTANCE.map(containersService.getContainersByPlantation(plantation));
    }
}
