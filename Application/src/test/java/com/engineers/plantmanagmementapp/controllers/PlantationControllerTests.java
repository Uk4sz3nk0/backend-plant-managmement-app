package com.engineers.plantmanagmementapp.controllers;

import com.engineers.plantmanagmementapp.controller.PlantationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PlantationController.class)
public class PlantationControllerTests {

    @Autowired
    private MockMvc mockMvc;
}
