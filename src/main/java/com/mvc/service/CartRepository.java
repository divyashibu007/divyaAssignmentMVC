package com.mvc.service;
import com.mvc.model.Carts;

import org.springframework.data.jpa.repository.JpaRepository;




public interface CartRepository extends JpaRepository<Carts, Integer> {
}







