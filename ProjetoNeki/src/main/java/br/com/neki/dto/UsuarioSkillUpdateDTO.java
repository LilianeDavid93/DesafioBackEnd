package br.com.neki.dto;

import br.com.neki.enums.SkillLevelEnum;

public class UsuarioSkillUpdateDTO {

	private Integer usuarioSkillId;
	private SkillLevelEnum novoLevel;
	
	public Integer getUsuarioSkillId() {
		return usuarioSkillId;
	}
	public void setUsuarioSkillId(Integer usuarioSkillId) {
		this.usuarioSkillId = usuarioSkillId;
	}
	public SkillLevelEnum getNovoLevel() {
		return novoLevel;
	}
	public void setNovoLevel(SkillLevelEnum novoLevel) {
		this.novoLevel = novoLevel;
	}
	
}
