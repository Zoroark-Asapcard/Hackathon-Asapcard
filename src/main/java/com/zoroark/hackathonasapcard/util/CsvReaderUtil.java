package com.zoroark.hackathonasapcard.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CsvReaderUtil {

    public static void readCSVFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            System.err.println("File path cannot be null or empty");
            return;
        }

        ClassLoader classLoader = CsvReaderUtil.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(filePath);
             InputStreamReader reader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                if (tokenizer.countTokens() != 7) {
                    System.err.println("Invalid CSV format: " + line);
                    continue;
                }

                String transactionId = tokenizer.nextToken();
                String transactionDate = tokenizer.nextToken();
                String document = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                int age = Integer.parseInt(tokenizer.nextToken());
                double transactionAmount = Double.parseDouble(tokenizer.nextToken());
                int numberOfInstallments = Integer.parseInt(tokenizer.nextToken());

                // Print the extracted fields
                System.out.println("Transaction ID: " + transactionId);
                System.out.println("Transaction Date: " + transactionDate);
                System.out.println("Document: " + document);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Transaction Amount: " + transactionAmount);
                System.out.println("Number of Installments: " + numberOfInstallments);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
    }

}
