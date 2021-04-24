package trilv.tool.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import trilv.tool.entity.Project;
import trilv.tool.service.MapValidationService;
import trilv.tool.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MapValidationService mapValidationService;

	@PostMapping("")
	public ResponseEntity<?> saveProject(@Valid @RequestBody Project project, BindingResult error) {
	    ResponseEntity<Map<String, String>> resultError = mapValidationService.validationError(error);
	    if(resultError != null) return resultError;
	    
		Project result = projectService.saveProject(project);
		return new ResponseEntity<Project>(result, result != null ? HttpStatus.ACCEPTED : HttpStatus.FAILED_DEPENDENCY);
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?> findProject(@PathVariable String projectId) {
	    Project result = projectService.findProjectById(projectId);
        return new ResponseEntity<Project>(result, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public ResponseEntity<?> findAllProject() {
	    return new ResponseEntity<Iterable<Project>>(projectService.findAll(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/delete")
	public ResponseEntity<?> removeProject(@RequestParam String projectId) {
	    projectService.deleteProject(projectId);
	    return new ResponseEntity<String>("Project with identifier " + projectId + " was deleted", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateProject(@RequestBody Project project) {
	    Project result = projectService.updateProject(project);
	    return new ResponseEntity<Project>(result, HttpStatus.OK);
	}
}