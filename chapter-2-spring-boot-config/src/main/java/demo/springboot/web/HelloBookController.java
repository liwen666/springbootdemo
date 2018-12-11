package demo.springboot.web;

import demo.springboot.config.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Spring Boot Hello案例
 *
 * Created by bysocket on 26/09/2017.
 */
@RestController
public class HelloBookController {

    @Autowired
    BookProperties bookProperties;

    @GetMapping("/book/hello")
    public String sayHello() {
        return "Hello， " + bookProperties.getWriter() + " is writing "
                + bookProperties.getName() + " ！";
    }
    @GetMapping("/book/putVal/{val}")
    public String putVal (@PathVariable("val") String val) {
        System.out.println(val);
        return "Hello， " + bookProperties.getWriter() + " is writing "
                + bookProperties.getName() + " ！";
    }
    @RequestMapping("/book/putObj/")
    public String putObj (@RequestBody Map<String,Object> val) {

        System.out.println(val);
        System.out.println(val.get("a"));
        return "Hello， " + bookProperties.getWriter() + " is writing "
                + bookProperties.getName() + " ！";
    }
}
