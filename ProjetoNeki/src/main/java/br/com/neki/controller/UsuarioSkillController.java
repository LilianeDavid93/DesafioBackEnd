package br.com.neki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.dto.SkillsDetailsDTO;
import br.com.neki.dto.UsuarioSkillDTO;
import br.com.neki.dto.UsuarioSkillUpdateDTO;
import br.com.neki.service.UsuarioSkillService;

@RestController
@RequestMapping("/usuarioskill")
public class UsuarioSkillController {

	@Autowired
	UsuarioSkillService usuarioSkillService;

	@GetMapping("/{id}")
	public ResponseEntity<List<SkillsDetailsDTO>> getId(@PathVariable(name = "id") final Integer usuarioSkillId) {
		return ResponseEntity.ok(usuarioSkillService.getAllSkills(usuarioSkillId));
	}

	@PostMapping("/associar")
    public ResponseEntity<Boolean> associarSkill(@RequestBody UsuarioSkillDTO usuarioSkill) {
        boolean response = usuarioSkillService.associarSkill(usuarioSkill);
        
        if(response == true) {
        	return new ResponseEntity<>(response, HttpStatus.CREATED);
        }        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Boolean> updateLevel(@PathVariable(name = "id") final Integer usuarioSkillId, @RequestBody UsuarioSkillUpdateDTO usuarioSkillUpdateDTO){
		return new ResponseEntity<>(usuarioSkillService.updateLevel(usuarioSkillId, usuarioSkillUpdateDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteSkill(@PathVariable(name = "id") final Integer usuarioSkillId){
		return new ResponseEntity<>(usuarioSkillService.deletarSkill(usuarioSkillId),HttpStatus.NO_CONTENT);
	}
}