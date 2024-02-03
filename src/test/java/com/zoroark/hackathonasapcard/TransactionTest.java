package com.zoroark.hackathonasapcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.zoroark.hackathonasapcard.model.Installment;
import com.zoroark.hackathonasapcard.model.Transaction;

public class TransactionTest {
	//@Autowired
		//private TestRestTemplate testRestTemplate;
		
		//@Autowired
		//private TransactionRepository transactionRepository;
		
		@Autowired
		private Installment installment;
		
		@Mock
		private Transaction transaction;
		
		 @Before(value = "")
		    public void setUp() {
		        installment = new Installment();
		    }
		
		 @Test
		    public void testId() {
		        assertNotNull(installment.getId());
		    }
		
		 @Test
		    public void testInstallmentNumber() {
		        int expectedInstallmentNumber = 1;
		        installment.setInstallmentNumber(expectedInstallmentNumber);
		        assertEquals(expectedInstallmentNumber, installment.getInstallmentNumber());
		    }
		
		 @Test
		    public void testValue() {
		        float expectedValue = 100.0f;
		        installment.setValue(expectedValue);
		        assertEquals(expectedValue, installment.getValue(), 0.0f);
		    }
		
		/* @Test
		    public void testData() {
		        LocalDateTime expectedData = LocalDateTime.now();
		        installment.setData(expectedData);
		        assertEquals(expectedData, installment.getData());
		    }
		*/
		

}
