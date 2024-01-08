package br.com.neki.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.neki.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByNomeUsuario(String nomeUsuario);
}
