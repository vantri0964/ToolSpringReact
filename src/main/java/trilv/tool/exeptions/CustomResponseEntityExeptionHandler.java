package trilv.tool.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExeptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdExeption(ProjectIdException project, WebRequest request) {
        ProjectIdExeptionResponse exceptionReponse = new ProjectIdExeptionResponse(project.getMessage());
        return new ResponseEntity<Object>(exceptionReponse, HttpStatus.BAD_REQUEST);
    }
}
