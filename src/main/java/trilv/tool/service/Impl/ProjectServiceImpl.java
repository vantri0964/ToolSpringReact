package trilv.tool.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trilv.tool.entity.Project;
import trilv.tool.repository.ProjectRepository;
import trilv.tool.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project saveProject(Project project) {
		try {
			return projectRepository.save(project);
		} catch (Exception e) {
			return null;
		}		
	}
	
}
