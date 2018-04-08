package com.pgeteste.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pgeteste.api.model.Usuario;
import com.pgeteste.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	public Usuario atualizar(Long codigo, Usuario usuario) {
		
		Usuario usuarioSalvo = buscarUsuarioPeloCodigo(codigo);
		BeanUtils.copyProperties(usuario, usuarioSalvo, "codigo");
		return usuarioRepository.save(usuarioSalvo);
	}

	public Usuario buscarUsuarioPeloCodigo(Long codigo) {
		Optional<Usuario> usuarioSalvo = usuarioRepository.findById(codigo);
		if(!usuarioSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return usuarioSalvo.get();
	}
}
