package gang.study.crud.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello-world")
    public String hello() {
        return "hello world";
    }

    @GetMapping("hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean("Hello World " + name);
    }
}
