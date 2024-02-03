package com.zoroark.hackathonasapcard;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoroark.hackathonasapcard.controller.InstallmentController;
import com.zoroark.hackathonasapcard.model.Installment;
import com.zoroark.hackathonasapcard.repository.InstallmentRepository;

@ExtendWith(MockitoExtension.class)
public class InstallmentControllerTest {

    @InjectMocks
    private InstallmentController installmentController;

    @Mock
    private InstallmentRepository installmentRepository;

    private MockMvc mockMvc;

    @Test
    public void getAllInstallments() throws Exception {
        // Arrange
        List<Installment> installmentList = new ArrayList<>();
        when(installmentRepository.findAll()).thenReturn(installmentList);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/installment"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    public void getInstallmentById() throws Exception {
        // Arrange
        UUID installmentId = UUID.randomUUID();
        Installment installment = new Installment();
        when(installmentRepository.findById(installmentId)).thenReturn(Optional.of(installment));

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/installment/{id}", installmentId))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(installmentId.toString()));
    }

    @Test
    public void getInstallmentByIdNotFound() throws Exception {
        // Arrange
        UUID installmentId = UUID.randomUUID();
        when(installmentRepository.findById(installmentId)).thenReturn(Optional.empty());

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/installment/{id}", installmentId))
               .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void createInstallment() throws Exception {
        // Arrange
        Installment installment = new Installment();
        when(installmentRepository.save(any())).thenReturn(installment);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/installment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(installment)))
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty());
    }

    @Test
    public void updateInstallment() throws Exception {
        // Arrange
        UUID installmentId = UUID.randomUUID();
        Installment existingInstallment = new Installment();
        when(installmentRepository.existsById(installmentId)).thenReturn(true);
        when(installmentRepository.save(any())).thenReturn(existingInstallment);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/installment/update/{id}", installmentId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(existingInstallment)))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(installmentId.toString()));
    }

    @Test
    public void updateInstallmentNotFound() throws Exception {
        // Arrange
        UUID installmentId = UUID.randomUUID();
        Installment nonExistingInstallment = new Installment();
        when(installmentRepository.existsById(installmentId)).thenReturn(false);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/installment/update/{id}", installmentId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(nonExistingInstallment)))
               .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void deleteInstallment() throws Exception {
        // Arrange
        UUID installmentId = UUID.randomUUID();
        when(installmentRepository.findById(installmentId)).thenReturn(Optional.of(new Installment()));

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/installment/{id}", installmentId))
               .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void deleteInstallmentNotFound() throws Exception {
        // Arrange
        UUID installmentId = UUID.randomUUID();
        when(installmentRepository.findById(installmentId)).thenReturn(Optional.empty());

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/installment/{id}", installmentId))
               .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void handleException() throws Exception {
        // Arrange
        UUID installmentId = UUID.randomUUID();
        when(installmentRepository.existsById(installmentId)).thenReturn(false);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/installment/update/{id}", installmentId)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
               .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(installmentController).build();
    }
}

