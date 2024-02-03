package com.zoroark.hackathonasapcard.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

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

	        List<String[]> linhas = csvReader.readAll();

	        for (String[] linha : linhas) {
	            for (String coluna : linha) {
	                System.out.print(coluna + " | ");
	            }
	            System.out.println();
	        }

	        csvReader.close();
	    } catch (IOException | CsvException e) {
	        e.printStackTrace();
	    }
	}
}
