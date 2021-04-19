package trilv.tool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value = "/home", method= RequestMethod.GET)
	public String index() {
		System.out.println("to do");
		return "tri";
	}
}
