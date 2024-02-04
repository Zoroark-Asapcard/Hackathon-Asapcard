package com.zoroark.hackathonasapcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoroark.hackathonasapcard.model.Installment;
import com.zoroark.hackathonasapcard.repository.InstallmentRepository;

@Service
public class InstallmentService {

    @Autowired
    private InstallmentRepository installmentRepository;

    public void saveInstallment(Installment installment) {
        installmentRepository.save(installment);
    }

    // Outros métodos relacionados a parcelas, se necessário
}
