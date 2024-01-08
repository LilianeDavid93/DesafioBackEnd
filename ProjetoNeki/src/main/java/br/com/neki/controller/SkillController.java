package br.com.neki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.dto.SkillDTO;
import br.com.neki.entity.Skill;
import br.com.neki.service.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {

	@Autowired
	SkillService skillService;
	
	@GetMapping
	public ResponseEntity<List<SkillDTO>> getAllSkills(){
		return new ResponseEntity<>(skillService.getAllSkills(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SkillDTO> getSkillById(@PathVariable Integer id){
		SkillDTO skillDTO = skillService.getSkillById(id);
		if(skillDTO != null) {
			return new ResponseEntity<>(skillDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(skillDTO, HttpStatus.NOT_FOUND);
		}
	}	

}

