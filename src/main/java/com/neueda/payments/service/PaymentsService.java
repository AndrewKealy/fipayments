package com.neueda.payments.service;

import com.neueda.payments.model.Payment;
import org.springframework.stereotype.Service;

import java.util.*;

public interface PaymentsService {

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id);

    Payment save(Payment payment);



}
