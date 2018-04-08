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

import com.pgeteste.api.model.Local;
import com.pgeteste.api.model.Usuario;
import com.pgeteste.api.repository.LocalRepository;
import com.pgeteste.api.service.LocalService;

@RestController
@RequestMapping("/local")
public class LocalResource {
	
	@Autowired
	private LocalRepository localRepository;
	
	@Autowired
	private LocalService localService;
	
	
	@GetMapping
	public List<Local> listar(){
		return localRepository.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<Local> criar(@Valid @RequestBody Local local, HttpServletResponse response) {
		Local localSalvo = localRepository.save(local);
		return ResponseEntity.status(HttpStatus.CREATED).body(localSalvo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Local> atualizar(@PathVariable Long codigo, @Valid @RequestBody Local local){
		
		Local localSalvo = localService.atualizar(codigo,local);
		return ResponseEntity.ok(localSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		localRepository.deleteById(codigo);
	}
	
}
