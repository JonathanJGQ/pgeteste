package com.pgeteste.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgeteste.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/selective")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
}
