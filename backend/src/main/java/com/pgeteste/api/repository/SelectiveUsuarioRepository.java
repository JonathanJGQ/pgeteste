package com.pgeteste.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgeteste.api.model.Local;
import com.pgeteste.api.model.Selective;
import com.pgeteste.api.model.SelectiveUsuario;
import com.pgeteste.api.model.Usuario;

@Repository
public interface SelectiveUsuarioRepository extends JpaRepository<SelectiveUsuario, Long>{
	List<SelectiveUsuario> findBySelective(Selective selective);
}
