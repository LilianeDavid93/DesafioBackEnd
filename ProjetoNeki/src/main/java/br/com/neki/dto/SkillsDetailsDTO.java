package br.com.neki.dto;

import br.com.neki.enums.SkillLevelEnum;

public class SkillsDetailsDTO {

	private Integer usuarioSkillId;
	private SkillDTO skill;
	private SkillLevelEnum level;
	
	public Integer getUsuarioSkillId() {
		return usuarioSkillId;
	}
	public void setUsuarioSkillId(Integer usuarioSkillId) {
		this.usuarioSkillId = usuarioSkillId;
	}
	public SkillDTO getSkill() {
		return skill;
	}
	public void setSkill(SkillDTO skill) {
		this.skill = skill;
	}
	public SkillLevelEnum getLevel() {
		return level;
	}
	public void setLevel(SkillLevelEnum level) {
		this.level = level;
	}
}
