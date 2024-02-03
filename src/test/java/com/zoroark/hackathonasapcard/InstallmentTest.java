package com.zoroark.hackathonasapcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.zoroark.hackathonasapcard.model.Installment;
import com.zoroark.hackathonasapcard.model.Transaction;

public class InstallmentTest {

    private Installment installment;

    @Mock
    private Transaction transaction;
    
 //   @Before
 /* public void setUp() {
	  installment = new Installment();
    }
*/
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

    
}
