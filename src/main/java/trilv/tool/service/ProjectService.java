package trilv.tool.service;

import trilv.tool.entity.Project;

public interface ProjectService {
	public Project saveProject(Project project);
	
	public Project findProjectById(String id);
	
	public Iterable<Project> findAll();
	
	public void deleteProject(String id);
	
	public Project updateProject(Project project);
}
