package life.speed.community.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bee
 * @description
 * @create 2021-07-09 11:21
 */

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){return "index";}
}

