package com.loija.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loija.core.model.Manufacture;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Integer> {

}
