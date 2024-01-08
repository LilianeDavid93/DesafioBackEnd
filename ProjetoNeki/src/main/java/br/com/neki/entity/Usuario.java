package br.com.neki.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.neki.enums.SkillLevelEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "codigoUsuario",
		scope = Usuario.class
	)
public class Usuario {

	@Id
    @Column(nullable = false, updatable = false, name = "usu_cd_id")
    @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
	private Integer id;
	
	@Column(nullable = false, length = 200, unique = true)
	private String nomeUsuario;
	
	@Column(nullable = false, length = 200)
	private String senha;
		
	@OneToMany(mappedBy = "usuario")	
	private List<UsuarioSkill> usuarioSkills;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<UsuarioSkill> getUsuarioSkills() {
		return usuarioSkills;
	}

	public void setUsuarioSkills(List<UsuarioSkill> usuarioSkills) {
		this.usuarioSkills = usuarioSkills;
	}
	

	public void adicionarSkillComNivel(Skill skillExistente, SkillLevelEnum level) {
				
	}
}