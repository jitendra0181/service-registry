package com.jitendra.controller;

import com.jitendra.entity.PaymentEntity;
import com.jitendra.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public PaymentEntity doPayment(@RequestBody PaymentEntity entity){
        return paymentService.doPayment(entity);
    }
}
