package com.listakim.listakim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.listakim.listakim.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
