package com.neueda.payments;

import com.neueda.payments.model.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityTests {


    @Test
    void testEqualityOfPaymentUsingOnlyId() {
        Payment payment1 = new Payment();
        payment1.setId(12L);
        Payment payment2 = new Payment();
        payment2.setId(12L);

        Assertions.assertEquals(payment1, payment2);
    }


}
