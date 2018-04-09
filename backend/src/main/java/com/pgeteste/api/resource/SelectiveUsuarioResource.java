package com.pgeteste.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pgeteste.api.model.SelectiveLocal;
import com.pgeteste.api.model.SelectiveUsuario;
import com.pgeteste.api.repository.SelectiveUsuarioRepository;
import com.pgeteste.api.service.SelectiveUsuarioService;

@RestController
@RequestMapping("/selectiveusuario")
public class SelectiveUsuarioResource {
	
	@Autowired
	private SelectiveUsuarioRepository selectiveUsuarioRepository;
	
	@Autowired
	private SelectiveUsuarioService selectiveUsuarioService;
	
	@GetMapping
	public List<SelectiveUsuario> listar(){
		return selectiveUsuarioRepository.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<SelectiveUsuario> criar(@Valid @RequestBody SelectiveUsuario selectiveUsuario, HttpServletResponse response) {
		SelectiveUsuario selectiveUsuarioSalvo = selectiveUsuarioRepository.save(selectiveUsuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(selectiveUsuarioSalvo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<SelectiveUsuario> atualizar(@PathVariable Long codigo, @Valid @RequestBody SelectiveUsuario selectiveUsuario){
		
		SelectiveUsuario selectiveUsuarioSalvo = selectiveUsuarioService.atualizar(codigo,selectiveUsuario);
		return ResponseEntity.ok(selectiveUsuarioSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		selectiveUsuarioRepository.deleteById(codigo);
	}
	
}
