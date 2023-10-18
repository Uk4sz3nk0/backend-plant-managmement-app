package com.engineers.plantmanagmementapp;

import com.engineers.plantmanagmementapp.record.RegisterRequest;
import com.engineers.plantmanagmementapp.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.engineers.plantmanagmementapp.enums.Role.ADMIN;

@SpringBootApplication
public class PlantManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantManagementAppApplication.class, args);
	}
}
