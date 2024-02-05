package com.zoroark.hackathonasapcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoroark.hackathonasapcard.model.Installment;
import com.zoroark.hackathonasapcard.service.InstallmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/installments")
public class InstallmentController {
    @Autowired
    private InstallmentService installmentService;

    @PostMapping
    public ResponseEntity<Installment> criarInstallment(@Valid @RequestBody Installment installment) {
        Installment novoInstallment = installmentService.criarInstallment(installment);
        return new ResponseEntity<>(novoInstallment, HttpStatus.CREATED);
    }
}
