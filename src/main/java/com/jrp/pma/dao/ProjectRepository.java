package com.jrp.pma.dao;

import com.jrp.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository  extends CrudRepository<Project, Long> {

}
