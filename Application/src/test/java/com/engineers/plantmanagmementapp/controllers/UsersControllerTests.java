package com.engineers.plantmanagmementapp.controllers;

import com.engineers.plantmanagmementapp.controller.PlantationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlantationController.class)
public class UsersControllerTests extends AbstractControllerTests {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    void shouldSetUserRole() throws Exception {
//        isGivenUser(USER_ID);
//        final String jwtToken = getJwtToken();
//        mockMvc.perform(post("/users/set-user-role")
//                .header(HttpHeaders.AUTHORIZATION, BEARER + jwtToken)
//                .param("userId", "1")
//                .param("role", "ROLE_WAREHOUSEMAN"))
//                .andExpect(status().isOk());
//    }
}
