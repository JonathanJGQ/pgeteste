package com.pgeteste.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pgeteste.api.model.SelectiveLocal;
import com.pgeteste.api.model.SelectiveUsuario;
import com.pgeteste.api.repository.SelectiveUsuarioRepository;

@Service
public class SelectiveUsuarioService {

	@Autowired 
	private SelectiveUsuarioRepository selectiveUsuarioRepository;
	
	public SelectiveUsuario atualizar(Long codigo, SelectiveUsuario selectiveUsuario) {
		
		SelectiveUsuario selectiveUsuarioSalvo = buscarSelectiveUsuarioPeloCodigo(codigo);
		BeanUtils.copyProperties(selectiveUsuario, selectiveUsuarioSalvo, "codigo");
		return selectiveUsuarioRepository.save(selectiveUsuarioSalvo);
	}

	public SelectiveUsuario buscarSelectiveUsuarioPeloCodigo(Long codigo) {
		Optional<SelectiveUsuario> selectiveLocalSalvo = selectiveUsuarioRepository.findById(codigo);
		if(!selectiveLocalSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return selectiveLocalSalvo.get();
	}
}
