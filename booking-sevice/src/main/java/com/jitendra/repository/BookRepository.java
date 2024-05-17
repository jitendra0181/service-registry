package com.jitendra.repository;

import com.jitendra.entity.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookOrder, Integer> {
}
