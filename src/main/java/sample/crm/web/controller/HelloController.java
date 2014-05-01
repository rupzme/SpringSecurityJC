package sample.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class HelloController {
 
	@RequestMapping(value ={"/"}, method = RequestMethod.GET)
    public String showHome(Model m) {
        m.addAttribute("name", "Hello Anonymous");
        return "welcome";
    }
	
    @RequestMapping(value ={"/user**"}, method = RequestMethod.GET)
    public String showHomeUser(Model m) {
        m.addAttribute("name", "Hello User");
        return "user/helloUser";
    }
    
    @RequestMapping(value ={"/admin**"}, method = RequestMethod.GET)
    public String showHomeAdmin(Model m) {
        m.addAttribute("name", "Hello Admin");
        return "/admin/helloAdmin";
    }
}