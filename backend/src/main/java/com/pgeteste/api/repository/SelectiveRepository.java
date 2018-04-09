package com.pgeteste.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgeteste.api.model.Selective;

@Repository
public interface SelectiveRepository extends JpaRepository<Selective, Long>{

}
