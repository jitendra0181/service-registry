package com.jitendra.service;

import com.jitendra.entity.PaymentEntity;
import com.jitendra.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ServerProperties serverProperties;
    public PaymentEntity doPayment(PaymentEntity entity) {
        entity.setPaymentStatus(paymentProcessing());
        entity.setTransactionId(UUID.randomUUID().toString());
        Integer port = serverProperties.getPort();
        log.info("Request served by port :{}", port);
        return paymentRepository.save(entity);
    }

    private String paymentProcessing() {
        return  new Random().nextBoolean()? "Success":"Failure";
    }
}
