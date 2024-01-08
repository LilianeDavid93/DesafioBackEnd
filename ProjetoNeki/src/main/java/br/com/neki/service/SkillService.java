package br.com.neki.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.dto.SkillDTO;
import br.com.neki.entity.Skill;
import br.com.neki.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	SkillRepository skillRepository;
	
	public List<SkillDTO> getAllSkills(){
		List<Skill> skills = skillRepository.findAll();
		List<SkillDTO> skillsDto = new ArrayList<SkillDTO>();
		for(Skill skill: skills) {			
			skillsDto.add(entityToDto(skill));
		}
		return skillsDto;			
	}
	
	private SkillDTO entityToDto(Skill entity){
		SkillDTO dto = new SkillDTO();		
		dto.setNomeSkill(entity.getNomeSkill());
		dto.setId(entity.getId());
		return dto;
	}
	
	public SkillDTO getSkillById(Integer id) {
		Skill skill = skillRepository.findById(id).orElse(null);
		SkillDTO skillDTO = new SkillDTO();

		if (skill != null)
			skillDTO = entityToDto(skill);

		return skillDTO;
	}
}
	


