package com.engineers.plantmanagmementapp.controllers;

import com.engineers.plantmanagmementapp.PlantManagerAppTests;
import com.engineers.plantmanagmementapp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@PlantManagerAppTests
public class HarvestsControllerTests extends AbstractControllerTests {

    private static final String DIRECTORY_PREFIX = "harvests" + File.separator;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldAddHarvest() throws Exception {

    }

    @Test
    void shouldAddUserHarvest() throws Exception {

    }

    @Test
    void shouldDeleteHarvest() throws Exception {
    }

    @Test
    void shouldDeleteUserHarvest() throws Exception {
    }

    @Test
    void shouldEditHarvest() throws Exception {
    }

    @Test
    void shouldEditUserHarvest() throws Exception {
    }

    @Test
    void shouldGetHarvestById() throws Exception {
    }

    @Test
    void shouldGetHarvests() throws Exception {
    }

    @Test
    void shouldGetHarvestsByDate() throws Exception {
    }

    @Test
    void shouldGetHarvestsBySeason() throws Exception {
    }

    @Test
    void shouldGetHarvestsInDateRange() throws Exception {
    }

    @Test
    void shouldGetUserHarvestById() throws Exception {
    }

    @Test
    void shouldGetUserHarvests() throws Exception {
    }

    @Test
    void shouldGetUserHarvestByPlantation() throws Exception {
    }
}
