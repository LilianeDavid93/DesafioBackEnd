package br.com.neki.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.dto.SkillDTO;
import br.com.neki.dto.SkillsDetailsDTO;
import br.com.neki.dto.UsuarioSkillDTO;
import br.com.neki.dto.UsuarioSkillUpdateDTO;
import br.com.neki.entity.Skill;
import br.com.neki.entity.Usuario;
import br.com.neki.entity.UsuarioSkill;
import br.com.neki.repository.SkillRepository;
import br.com.neki.repository.UsuarioRepository;
import br.com.neki.repository.UsuarioSkillRepository;

@Service
public class UsuarioSkillService {

	@Autowired
	SkillRepository skillRespository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioSkillRepository usuarioSkillRepository;

	public List<SkillsDetailsDTO> getAllSkills(Integer usuarioId) {
		Optional<Usuario> usuarioExisteBanco = usuarioRepository.findById(usuarioId);
		if(!usuarioExisteBanco.isPresent()) {
			return new ArrayList<>();
		}
		
		List<UsuarioSkill> skillsUsuario = usuarioExisteBanco.get().getUsuarioSkills();
		List<SkillsDetailsDTO> skillsResponse = new ArrayList<>();
		
		for(UsuarioSkill skillUsuario : skillsUsuario) {
			SkillsDetailsDTO skillDetailsDTO = new SkillsDetailsDTO();			
			SkillDTO skillDTO = new SkillDTO();
			skillDTO.setId(skillUsuario.getSkill().getId());
			skillDTO.setNomeSkill(skillUsuario.getSkill().getNomeSkill());			
			skillDetailsDTO.setUsuarioSkillId(skillUsuario.getId());
			skillDetailsDTO.setLevel(skillUsuario.getLevel());
			skillDetailsDTO.setSkill(skillDTO);			
			skillsResponse.add(skillDetailsDTO);
		}
		
		return skillsResponse;	

	}

	public Boolean associarSkill(UsuarioSkillDTO usuarioSkillDto) {
		Optional<Usuario> usuarioExisteBanco = usuarioRepository.findById(usuarioSkillDto.getUsuarioId());
		Optional<Skill> skillExisteBanco = skillRespository.findById(usuarioSkillDto.getSkillId());

		if (usuarioExisteBanco.isPresent() && skillExisteBanco.isPresent()) {
			Usuario usuarioExistente = usuarioExisteBanco.get();
			Skill skillExistente = skillExisteBanco.get();
			List<SkillsDetailsDTO> skillsVinculadas = getAllSkills(usuarioSkillDto.getUsuarioId());
			for(SkillsDetailsDTO skill : skillsVinculadas) {
				if(skill.getSkill().getId().equals(usuarioSkillDto.getSkillId())) {
					return false;
				}
			}
			UsuarioSkill usuarioSkill = new UsuarioSkill();
			usuarioSkill.setUsuario(usuarioExistente);
			usuarioSkill.setSkill(skillExistente);
			usuarioSkill.setLevel(usuarioSkillDto.getLevel());
			UsuarioSkill usuarioSkillNovo = usuarioSkillRepository.save(usuarioSkill);
			if (usuarioSkillNovo != null) {
				return true;
			}

			return false;

		} else {
			return false;
		}
	}

	public Boolean updateLevel(Integer usuarioSkillId, UsuarioSkillUpdateDTO usuarioSkillUpdateDTO) {
		Optional<UsuarioSkill> usuarioSkillExiste = usuarioSkillRepository.findById(usuarioSkillId);
		if(!usuarioSkillExiste.isPresent()) {
			return false;
		}
		
		usuarioSkillExiste.get().setLevel(usuarioSkillUpdateDTO.getNovoLevel());
		usuarioSkillRepository.save(usuarioSkillExiste.get());
		return true;
	}
	public Boolean deletarSkill(Integer usuarioSkillId){
		Optional<UsuarioSkill> usuarioSkillExiste = usuarioSkillRepository.findById(usuarioSkillId);
		if(!usuarioSkillExiste.isPresent()) {
			return false;
		}
		
		usuarioSkillRepository.deleteById(usuarioSkillId);
		return true;
	}
}
