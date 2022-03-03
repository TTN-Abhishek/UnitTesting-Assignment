package com.demo.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

    @Mock
    Order orderMock;

    @InjectMocks
    EmailService emailService;

    @Test
    public void sendEmailTest_PositiveCase() {

        orderMock=new Order(11, "Cake", 50);
        boolean b= emailService.sendEmail(orderMock, "Abhishek Kumar");
        assertTrue(b);

    }

    @Test(expected = RuntimeException.class)
    public void sendEmailTest_Exception() {
        emailService.sendEmail(new Order());
    }

}