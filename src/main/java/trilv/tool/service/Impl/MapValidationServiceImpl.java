package trilv.tool.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import trilv.tool.service.MapValidationService;

@Service
public class MapValidationServiceImpl implements MapValidationService{

    @Override
    public ResponseEntity<Map<String, String>> validationError(BindingResult result) {
        if(result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();
            for(FieldError e : result.getFieldErrors()) {
                errorMap.put(e.getField(), e.getDefaultMessage());
            }
            return new ResponseEntity< Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }

}
