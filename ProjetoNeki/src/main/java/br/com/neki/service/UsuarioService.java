package br.com.neki.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.dto.UsuarioDTO;
import br.com.neki.dto.UsuarioLoginResponseDTO;
import br.com.neki.entity.Usuario;
import br.com.neki.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public UsuarioDTO getUsuarioById(Integer id) {
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		UsuarioDTO usuarioDTO = new UsuarioDTO();

		if(usuario != null)
			usuarioDTO = entityToDto(usuario);
		
		return usuarioDTO;
	}
	
	public Integer novoUsuario(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario(usuarioDto.getNomeUsuario());
		usuario.setSenha(usuarioDto.getSenha());
		usuario = usuarioRepository.save(usuario);
		return usuario.getId();		
	}
	
	public UsuarioLoginResponseDTO login(UsuarioDTO usuarioDto) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByNomeUsuario(usuarioDto.getNomeUsuario());
		if(usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();
			if(usuarioDto.getSenha().equals(usuario.getSenha())) {
				UsuarioLoginResponseDTO usuarioLoginDto = new UsuarioLoginResponseDTO();
				usuarioLoginDto.setId(usuario.getId());
				usuarioLoginDto.setNomeUsuario(usuario.getNomeUsuario());
				usuarioLoginDto.setAutenticado(true);
				return usuarioLoginDto;
			}
		}
		
		return null;
	}

	private UsuarioDTO entityToDto(Usuario entity) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNomeUsuario(entity.getNomeUsuario());
		return dto;
	}
	
	
}
