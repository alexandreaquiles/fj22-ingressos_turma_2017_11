package br.com.caelum.ingresso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nando on 03/03/17.
 */
@Controller
public class HomeController {

    @GetMapping("/") //a partir da 4.3.x
    //@RequestMapping(value="/", method=RequestMethod.GET)
    public String home(){
        return "home";
    }
}
