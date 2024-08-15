package com.neueda.payments.control;

import com.neueda.payments.exceptions.PaymentNotFoundException;
import com.neueda.payments.model.Payment;
import com.neueda.payments.service.PaymentsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/payment")
public class PaymentController {

    private final PaymentsService paymentsService;

    public PaymentController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @GetMapping
    public List<Payment> retrieveAllPayments(@RequestParam(value = "country", required = false) String country,
                                             @RequestParam(value = "orderId", required = false) String orderId) {
        if (country != null) {
            return paymentsService.getAllByCountry(country);
        } else if (orderId != null) {
            return paymentsService.getAllByOrderId(orderId);
        } else {
            return paymentsService.getAllPayments();
        }
    }

    @GetMapping(value = "/{id}", produces =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Payment getPaymentById(@PathVariable("id") Long id) throws PaymentNotFoundException {
        return  paymentsService.getPaymentById(id);
    }

    @PostMapping
    public Payment createNewPayment(@RequestBody Payment newPayment) {
        return paymentsService.save(newPayment);
    }
}
