package trilv.tool.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trilv.tool.entity.Project;
import trilv.tool.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping("")
	public ResponseEntity<?> saveProject(@Valid @RequestBody Project project, BindingResult error) {
	    if(error.hasErrors()) {
	        return new ResponseEntity<String>("Invalid project object", HttpStatus.BAD_REQUEST);
	    }
	    
		Project result = projectService.saveProject(project);
		return new ResponseEntity<Project>(result, result != null ? HttpStatus.ACCEPTED : HttpStatus.FAILED_DEPENDENCY);
	}
}