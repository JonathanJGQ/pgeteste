package com.pgeteste.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pgeteste.api.model.Local;
import com.pgeteste.api.model.Usuario;
import com.pgeteste.api.repository.LocalRepository;

@Service
public class LocalService {

	@Autowired 
	private LocalRepository localRepository;
	
	public Local atualizar(Long codigo, Local local) {
		
		Local localSalvo = buscarLocalPeloCodigo(codigo);
		BeanUtils.copyProperties(local, localSalvo, "codigo");
		return localRepository.save(localSalvo);
	}

	public Local buscarLocalPeloCodigo(Long codigo) {
		Optional<Local> localSalvo = localRepository.findById(codigo);
		if(!localSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return localSalvo.get();
	}
}
