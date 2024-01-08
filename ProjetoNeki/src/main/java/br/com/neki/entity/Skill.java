package br.com.neki.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "codigoSkill",
		scope = Skill.class)
public class Skill {
	
	@Id
    @Column(nullable = false, updatable = false, name = "skill_cd_id")
    @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    private Integer id;
	
	@Column(nullable = false, length = 200, unique = true)
    private String nomeSkill;
		
	@OneToMany(mappedBy = "skill")
	private List<UsuarioSkill> usuarioSkills;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeSkill() {
		return nomeSkill;
	}

	public void setNomeSkill(String nomeSkill) {
		this.nomeSkill = nomeSkill;
	}

	public List<UsuarioSkill> getUsuarioSkills() {
		return usuarioSkills;
	}

	public void setUsuarioSkills(List<UsuarioSkill> usuarioSkills) {
		this.usuarioSkills = usuarioSkills;
	}
}

