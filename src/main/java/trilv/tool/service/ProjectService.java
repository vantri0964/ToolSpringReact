package trilv.tool.service;

import org.springframework.stereotype.Service;

import trilv.tool.entity.Project;

@Service
public interface ProjectService {
	public Project saveProject(Project project);
}
