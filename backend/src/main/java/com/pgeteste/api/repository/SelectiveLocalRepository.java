package com.pgeteste.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pgeteste.api.model.Selective;
import com.pgeteste.api.model.SelectiveLocal;

@Repository
public interface SelectiveLocalRepository extends JpaRepository<SelectiveLocal, Long>{
	List<SelectiveLocal> findBySelective(Selective selective);
	
}
