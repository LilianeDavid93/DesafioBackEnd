package br.com.neki.entity;


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
@Table(name = "usuarioSkill")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "codigoUsuarioSkill",
		scope = UsuarioSkill.class)
public class UsuarioSkill {
	
	@Id
    @Column(nullable = false, updatable = false, name = "codUsuSkill_cd_id")
    @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    private Integer id;
	
	@Column(nullable = false, length = 200,unique =true)
    private SkillLevelEnum Level;
			
	@ManyToOne
	@JoinColumn(name = "codigoUsuario", referencedColumnName = "usu_cd_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "codigoSkill", referencedColumnName = "skill_cd_id")
	private Skill skill;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SkillLevelEnum getLevel() {
		return Level;
	}

	public void setLevel(SkillLevelEnum level) {
		Level = level;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
 
	public UsuarioSkill() {
		
	}
}

