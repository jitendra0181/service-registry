package com.jitendra.controller;

import com.jitendra.common.BookingRequest;
import com.jitendra.common.BookingResponse;
import com.jitendra.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private BookService bookService;

    @PostMapping("/bookOrder")
    public BookingResponse bookOrder(@RequestBody BookingRequest request){
         return bookService.bookOrder(request);
    }
}
