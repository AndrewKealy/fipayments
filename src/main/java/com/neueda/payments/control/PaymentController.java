package com.neueda.payments.control;

import com.neueda.payments.model.Payment;
import com.neueda.payments.service.PaymentsService;
import com.neueda.payments.service.PaymentsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/payment")
public class PaymentController {

    private final PaymentsService paymentsService;

    public PaymentController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @GetMapping
    public List<Payment> retrieveAllPayments() {
        return paymentsService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") Long id) {
        return  paymentsService.getPaymentById(id);
    }
}
