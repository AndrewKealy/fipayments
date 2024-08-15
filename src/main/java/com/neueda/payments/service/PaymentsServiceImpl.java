package com.neueda.payments.service;

import com.neueda.payments.exceptions.PaymentNotFoundException;
import com.neueda.payments.model.Payment;
import com.neueda.payments.repositories.PaymentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    private final Logger logger = LoggerFactory.getLogger(PaymentsServiceImpl.class);

    private final PaymentsRepository paymentsRepository;

    public PaymentsServiceImpl(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();
    }



    @Override
    public Payment save(Payment payment) {
        return paymentsRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) throws PaymentNotFoundException {
        return paymentsRepository.findById(id).orElseThrow( () ->
             new PaymentNotFoundException("No Payment found for id " + id)
        );
    }

    @Override
    public List<Payment> getAllByCountry(String country) {
        logger.info("Getting all payments for country {}", country);
        return paymentsRepository.findAllByCountry(country);
    }

    @Override
    public List<Payment> getAllByOrderId(String orderId) {
        return paymentsRepository.findAllByOrderId(orderId);
    }

    @Override
    public List<String> getAllCountries() {
        return paymentsRepository.findAll().stream().map(Payment::getCountry).distinct().sorted().toList();
    }
}
