package com.pgeteste.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgeteste.api.model.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long>{

}
