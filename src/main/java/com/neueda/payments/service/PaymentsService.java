package com.neueda.payments.service;

import com.neueda.payments.exceptions.PaymentNotFoundException;
import com.neueda.payments.model.Payment;
import java.util.*;

public interface PaymentsService {

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id) throws PaymentNotFoundException;

    Payment save(Payment payment);

    List<Payment> getAllByCountry(String country);

    List<Payment> getAllByOrderId(String orderId);

    List<String> getAllCountries();
}
