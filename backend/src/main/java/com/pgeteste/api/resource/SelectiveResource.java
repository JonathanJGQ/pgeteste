package com.pgeteste.api.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.pgeteste.api.model.Selective;
import com.pgeteste.api.model.SelectiveLocal;
import com.pgeteste.api.model.SelectiveUsuario;
import com.pgeteste.api.model.Usuario;
import com.pgeteste.api.repository.LocalRepository;
import com.pgeteste.api.repository.SelectiveLocalRepository;
import com.pgeteste.api.repository.SelectiveRepository;
import com.pgeteste.api.repository.SelectiveUsuarioRepository;
import com.pgeteste.api.repository.UsuarioRepository;
import com.pgeteste.api.service.LocalService;
import com.pgeteste.api.service.UsuarioService;

@RestController
@RequestMapping("/selective")
@CrossOrigin(origins = "http://localhost:8080")
public class SelectiveResource {
	
	@Autowired
	private SelectiveRepository selectiveRepository;
	
	@Autowired
	private SelectiveLocalRepository selectiveLocalRepository;
	
	@Autowired
	private SelectiveUsuarioRepository selectiveUsuarioRepository;
	
	@Autowired
	private LocalRepository localRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LocalService localService;
	
	@GetMapping("/{codigo}")
	private ResponseEntity<?> buscarSelective(@PathVariable Long codigo){
		Optional<Selective> selective = selectiveRepository.findById(codigo);
		
		if(!selective.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(selective.get());	
	}
	
	@GetMapping("/{codigo}/users")
	private ResponseEntity<?> listarUsuarios(@PathVariable Long codigo) {
		Optional<Selective> selective = selectiveRepository.findById(codigo);
		if(!selective.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		List<SelectiveUsuario> lista = selectiveUsuarioRepository.findBySelective(selective.get());
		List<Usuario> listUser = new ArrayList<>();		
		for(SelectiveUsuario selectUsuario : lista) {
			listUser.add(selectUsuario.getUsuario());
		}
		
		Map<String, Object> map = new HashMap();
		map.put("selective", selective.get());
		map.put("users", listUser);
		
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/{codigo}/places")
	private ResponseEntity<?> listarLocais(@PathVariable Long codigo) {
		Optional<Selective> selective = selectiveRepository.findById(codigo);
		if(!selective.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		List<SelectiveLocal> lista = selectiveLocalRepository.findBySelective(selective.get());
		List<Local> listLocal = new ArrayList<>();		
		for(SelectiveLocal selectLocal : lista) {
			listLocal.add(selectLocal.getLocal());
		}
		
		Map<String, Object> map = new HashMap();
		map.put("selective", selective.get());
		map.put("places", listLocal);
		
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/{codigo}/user")
	public ResponseEntity<Selective> criarUsuario(@Valid @RequestBody Usuario usuario, @PathVariable Long codigo, HttpServletResponse response) {
		Optional<Selective> selective = selectiveRepository.findById(codigo);
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		selectiveUsuarioRepository.save(new SelectiveUsuario(usuarioSalvo,selective.get()));
		return ResponseEntity.status(HttpStatus.CREATED).body(selective.get());
	}
	
	@PostMapping("/{codigo}/place")
	public ResponseEntity<Selective> criarLocal(@Valid @RequestBody Local local, @PathVariable Long codigo, HttpServletResponse response) {
		Optional<Selective> selective = selectiveRepository.findById(codigo);
		Local localSalvo = localRepository.save(local);
		selectiveLocalRepository.save(new SelectiveLocal(localSalvo,selective.get()));
		return ResponseEntity.status(HttpStatus.CREATED).body(selective.get());
	}
	
	@PutMapping("/{codigo}/user")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long codigo, @Valid @RequestBody Usuario usuario){
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}
	
	@PutMapping("/{codigo}/place")
	public ResponseEntity<Local> atualizarLocal(@PathVariable Long codigo, @Valid @RequestBody Local local){
		Local localSalvo = localRepository.save(local);
		return ResponseEntity.ok(localSalvo);
	}
	
	@DeleteMapping("/{codigo}/user/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerUsuario(@PathVariable Long codigo, @PathVariable Long id) {
		Optional<Selective> selective = selectiveRepository.findById(codigo);
		
		List<SelectiveUsuario> lista = selectiveUsuarioRepository.findBySelective(selective.get());
		Usuario usuario = usuarioService.buscarUsuarioPeloCodigo(id);
		for(SelectiveUsuario selectUsuario : lista) {
			if(selectUsuario.getCodigo() == usuario.getUsuarioCodigo()) {
				selectiveUsuarioRepository.deleteById(selectUsuario.getCodigo());
			}
		}
	}
	
	@DeleteMapping("/{codigo}/place/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerLocal(@PathVariable Long codigo, @PathVariable Long id) {
		Optional<Selective> selective = selectiveRepository.findById(codigo);
		
		List<SelectiveLocal> lista = selectiveLocalRepository.findBySelective(selective.get());	
		Local local = localService.buscarLocalPeloCodigo(id);
		for(SelectiveLocal selectLocal : lista) {
			if(selectLocal.getCodigo() == local.getLocalCodigo()) {
				selectiveLocalRepository.deleteById(selectLocal.getCodigo());
			}
		}
	}
	
}
