package com.neueda.payments;

import com.neueda.payments.control.CountryController;
import com.neueda.payments.exceptions.PaymentNotFoundException;
import com.neueda.payments.model.Payment;
import com.neueda.payments.repositories.PaymentsRepository;
import com.neueda.payments.repositories.UsersRepository;
import com.neueda.payments.service.PaymentsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;


import java.util.List;
import java.util.Optional;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,  HibernateJpaAutoConfiguration.class })
public class ServiceTests {

    @Autowired
    PaymentsService paymentsService;

    @Autowired
    private CountryController countryController;

    @MockBean
    private PaymentsRepository paymentsRepository;

    @MockBean
    private UsersRepository usersRepository;


    @BeforeEach
    public void setUp() {
        Payment p1 = new Payment();
        p1.setId(1L);
        p1.setCountry("FRA");
        Payment p2 = new Payment();
        p2.setId(2L);
        p2.setCountry("FRA");
        Payment p3 = new Payment();
        p3.setId(3L);
        p3.setCountry("EST");
        Payment p4 = new Payment();
        p4.setId(4L);
        p4.setCountry("EST");

        Mockito.when(paymentsRepository.findById(123L)).thenReturn(Optional.empty());
        Mockito.when(paymentsRepository.findAll()).thenReturn(List.of(p1, p2, p3, p4));
    }

    @Test
    public void testExceptionThrownForNoPaymentInDb()  {
            Assertions.assertThrows(PaymentNotFoundException.class, () ->
            {
                paymentsService.getPaymentById(123L);
            });
    }

    @Test
    public void testReturnedCountryListIsUnique() {
        Assertions.assertEquals(List.of("EST", "FRA"), paymentsService.getAllCountries());
    }

    @Test
    public void testCountryController() {
        Assertions.assertEquals(List.of("EST", "FRA"), countryController.getCountries());
    }
}
