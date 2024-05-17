package com.jitendra.common;

import com.jitendra.entity.BookOrder;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private BookOrder bookOrder;
    private PaymentEntity paymentEntity;
}
