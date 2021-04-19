package trilv.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ToolFullStackApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("Start server");
		SpringApplication.run(ToolFullStackApplication.class, args);
	}

}
