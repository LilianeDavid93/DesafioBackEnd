package br.com.neki.dto;

import br.com.neki.enums.SkillLevelEnum;

public class UsuarioSkillDTO {

	private Integer usuarioId;
	private Integer skillId;
	private SkillLevelEnum level;
	
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Integer getSkillId() {
		return skillId;
	}
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}
	public SkillLevelEnum getLevel() {
		return level;
	}
	public void setLevel(SkillLevelEnum level) {
		this.level = level;
	}
		
}
