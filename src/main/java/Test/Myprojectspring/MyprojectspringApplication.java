package Test.Myprojectspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(path = "hi")
public class MyprojectspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyprojectspringApplication.class, args);
    }

    @GetMapping
    public String string() {
		
        return "hello shalom urakarya ubuswage";
    }

}
