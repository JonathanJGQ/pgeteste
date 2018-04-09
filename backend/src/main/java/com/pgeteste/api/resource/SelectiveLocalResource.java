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
import com.pgeteste.api.repository.SelectiveLocalRepository;
import com.pgeteste.api.service.SelectiveLocalService;

@RestController
@RequestMapping("/selectivelocal")
public class SelectiveLocalResource {
	
	@Autowired
	private SelectiveLocalRepository selectiveLocalRepository;
	
	@Autowired
	private SelectiveLocalService selectiveLocalService;
	
	@GetMapping
	public List<SelectiveLocal> listar(){
		return selectiveLocalRepository.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<SelectiveLocal> criar(@Valid @RequestBody SelectiveLocal selectiveLocal, HttpServletResponse response) {
		SelectiveLocal selectiveLocalSalvo = selectiveLocalRepository.save(selectiveLocal);
		return ResponseEntity.status(HttpStatus.CREATED).body(selectiveLocalSalvo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<SelectiveLocal> atualizar(@PathVariable Long codigo, @Valid @RequestBody SelectiveLocal selectiveLocal){
		
		SelectiveLocal selectiveLocalSalvo = selectiveLocalService.atualizar(codigo,selectiveLocal);
		return ResponseEntity.ok(selectiveLocalSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		selectiveLocalRepository.deleteById(codigo);
	}
	
}
