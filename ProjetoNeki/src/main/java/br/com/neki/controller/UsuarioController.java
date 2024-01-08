package br.com.neki.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.dto.UsuarioDTO;
import br.com.neki.dto.UsuarioLoginResponseDTO;
import br.com.neki.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController{

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Integer> novoUsuario(@RequestBody UsuarioDTO usuarioDto){
		Integer usuarioId = usuarioService.novoUsuario(usuarioDto);
		return new ResponseEntity<>(usuarioId, HttpStatus.CREATED);		
	}
	
	@PostMapping("/login")
	public ResponseEntity<UsuarioLoginResponseDTO> login(@RequestBody UsuarioDTO usuarioDto){
		UsuarioLoginResponseDTO usuario = usuarioService.login(usuarioDto);
		if(usuario != null) {
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(usuario, HttpStatus.BAD_REQUEST);		
		
	}
}