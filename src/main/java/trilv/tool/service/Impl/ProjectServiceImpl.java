package trilv.tool.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trilv.tool.entity.Project;
import trilv.tool.exeptions.ProjectIdException;
import trilv.tool.repository.ProjectRepository;
import trilv.tool.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException(
                    "Project ID " + project.getProjectIdentifier().toUpperCase() + " already exists");
        }
    }

    @Override
    public Project findProjectById(String id) {
       Project project = projectRepository.findByProjectIdentifier(id);
       if(project == null) {
           throw new ProjectIdException("Project id not exist");
       }
       return project;
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProject(String id) {
        Project project = projectRepository.findByProjectIdentifier(id);
        if(project == null) {
            throw new ProjectIdException("Not found project with project identifier: " + id);
        }
        projectRepository.delete(project);
        
    }

    @Override
    public Project updateProject(Project project) {
       
       Project result = projectRepository.findByProjectIdentifier(project.getProjectIdentifier());
       if(result == null) {
           throw new ProjectIdException("Not found project with project identifier: " + project.getProjectIdentifier());
       }
       project.setId(result.getId());
       return projectRepository.save(project);
    }

}
