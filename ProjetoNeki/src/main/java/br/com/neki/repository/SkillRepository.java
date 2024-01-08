package br.com.neki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.neki.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer>{

}