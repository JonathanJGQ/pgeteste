package com.pgeteste.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pgeteste.api.model.Local;
import com.pgeteste.api.model.SelectiveLocal;
import com.pgeteste.api.repository.SelectiveLocalRepository;

@Service
public class SelectiveLocalService {

	@Autowired 
	private SelectiveLocalRepository selectiveLocalRepository;
	
	public SelectiveLocal atualizar(Long codigo, SelectiveLocal selectiveLocal) {
		
		SelectiveLocal selectiveLocalSalvo = buscarSelectiveLocalPeloCodigo(codigo);
		BeanUtils.copyProperties(selectiveLocal, selectiveLocalSalvo, "codigo");
		return selectiveLocalRepository.save(selectiveLocalSalvo);
	}

	public SelectiveLocal buscarSelectiveLocalPeloCodigo(Long codigo) {
		Optional<SelectiveLocal> selectiveLocalSalvo = selectiveLocalRepository.findById(codigo);
		if(!selectiveLocalSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return selectiveLocalSalvo.get();
	}
}
