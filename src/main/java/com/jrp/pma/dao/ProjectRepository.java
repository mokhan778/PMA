package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>{
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value " + 
			"FROM project " + 
			"GROUP by stage")
	public List<ChartData> getProjectStatus();
	
	public Project findByProjectId(long theId);
}