package com.jitendra.service;

import com.jitendra.common.BookingRequest;
import com.jitendra.common.BookingResponse;
import com.jitendra.common.PaymentEntity;
import com.jitendra.entity.BookOrder;
import com.jitendra.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${baseUrl}")
    private String baseUrl;
    public BookingResponse bookOrder(BookingRequest bookingRequest) {
        PaymentEntity paymentEntity = new PaymentEntity();
        BookOrder bookOrder = bookingRequest.getBookOrder();
        paymentEntity.setAmount(bookOrder.getPrice());
        paymentEntity.setOrderId(bookOrder.getBookId());
        PaymentEntity paymentResponse = restTemplate.postForObject(baseUrl+"doPayment", paymentEntity, PaymentEntity.class);
        String response = paymentResponse.getPaymentStatus().equals("Success") ? "Payment Processed Successfully" : "Payment Failure";
        bookRepository.save(bookOrder);
        return new BookingResponse(bookOrder, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);

    }
}
