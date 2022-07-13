package com.loija.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loija.core.model.FactoryOrder;

@Repository
public interface FactoryOrderRepository extends JpaRepository<FactoryOrder, Integer> {

}
