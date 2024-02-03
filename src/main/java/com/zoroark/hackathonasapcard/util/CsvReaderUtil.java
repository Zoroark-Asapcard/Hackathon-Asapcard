package com.zoroark.hackathonasapcard.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zoroark.hackathonasapcard.service.TransactionService;

@Component
public class CsvReaderUtil {

	 @Autowired
	    private TransactionService transactionService;
	 
    public static void readCSVFile(String filePath) {
        try {
            // Obtain the ClassLoader associated with the CsvReaderUtil class
            ClassLoader classLoader = CsvReaderUtil.class.getClassLoader();
            // Get an InputStream for the specified file path using the ClassLoader
            InputStream inputStream = classLoader.getResourceAsStream(filePath);

            if (inputStream == null) {
                throw new FileNotFoundException("File not found: " + filePath);
            }

            // Create an InputStreamReader to read characters from the InputStream
            InputStreamReader reader = new InputStreamReader(inputStream);
            // Optionally, create a BufferedReader to improve reading performance
            BufferedReader bufferedReader = new BufferedReader(reader);
            
            JSONArray jsonArray = new JSONArray();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into fields using the ';' delimiter
                StringTokenizer tokenizer = new StringTokenizer(line, ";");

                // Extract the fields from the line
                String transactionId = tokenizer.nextToken();
                String transactionDate = tokenizer.nextToken();
                String document = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                int age = Integer.parseInt(tokenizer.nextToken());
                double transactionAmount = Double.parseDouble(tokenizer.nextToken());
                int numberOfInstallments = Integer.parseInt(tokenizer.nextToken());

                // Create a JSONObject for each line
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("transactionId", transactionId);
                jsonObject.put("transactionDate", transactionDate);
                jsonObject.put("document", document);
                jsonObject.put("name", name);
                jsonObject.put("age", age);
                jsonObject.put("transactionAmount", transactionAmount);
                jsonObject.put("numberOfInstallments", numberOfInstallments);

                // Add the JSONObject to the JSONArray
                jsonArray.put(jsonObject);
            }
            
//save transactions en db transactionservice.save
            
            
            // Print or handle JSON messages as needed
            System.out.println(jsonArray.toString(4));
            
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
