package com.zoroark.hackathonasapcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zoroark.hackathonasapcard.util.CsvReaderUtil;

@SpringBootApplication
public class HackathonasapcardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackathonasapcardApplication.class, args);
		
		// Teste da Leitura de Arquivo CSV
		String filePath = "input-data.csv";
        CsvReaderUtil.readCSVFile(filePath);
	}

}
