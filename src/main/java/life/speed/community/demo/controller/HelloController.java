package life.speed.community.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bee
 * @description
 * @create 2021-07-09 11:47
 */
@Controller
public class HelloController {

   

        @GetMapping("/hello")
        public String greeting(@RequestParam(name="name") String name, Model model) {
            model.addAttribute("name", name);
            return "hello";
        

    }
}
