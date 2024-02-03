package com.zoroark.hackathonasapcard.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvReaderUtil {

	public static void readCSVFile(String filePath) {
	    try {
	        ClassLoader classLoader = CsvReaderUtil.class.getClassLoader();
	        InputStream inputStream = classLoader.getResourceAsStream(filePath);

	        if (inputStream == null) {
	            throw new FileNotFoundException("File not found: " + filePath);
	        }

	        InputStreamReader reader = new InputStreamReader(inputStream);
	        CSVReader csvReader = new CSVReader(reader);
	        BufferedReader bufferedReader = new BufferedReader(reader);

	        /**List<String[]> linhas = csvReader.readAll();

	        for (String[] linha : linhas) {
	            for (String coluna : linha) {
	                System.out.print(coluna + " | ");
	            }
	            System.out.println();
	        }*/
	        
	        String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Usando StringTokenizer para separar os dados
                StringTokenizer tokenizer = new StringTokenizer(line, ";");

                // Extrair os dados da linha
                String idTransacao = tokenizer.nextToken();
                String dataTransacao = tokenizer.nextToken();
                String documento = tokenizer.nextToken();
                String nome = tokenizer.nextToken();
                int idade = Integer.parseInt(tokenizer.nextToken());
                double valorTransacao = Double.parseDouble(tokenizer.nextToken());
                int numParcelas = Integer.parseInt(tokenizer.nextToken());

                // Exibir os dados separadamente
                System.out.println("ID da Transação: " + idTransacao);
                System.out.println("Data da Transação: " + dataTransacao);
                System.out.println("Documento: " + documento);
                System.out.println("Nome: " + nome);
                System.out.println("Idade: " + idade);
                System.out.println("Valor da Transação: " + valorTransacao);
                System.out.println("Número de Parcelas: " + numParcelas);
                System.out.println();
            }
	        

	        csvReader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
