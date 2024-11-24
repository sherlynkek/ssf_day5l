package sg.edu.nus.iss.vttp5a_day5l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

import sg.edu.nus.iss.vttp5a_day5l.model.Person;
import sg.edu.nus.iss.vttp5a_day5l.service.PersonService;


@Controller
@RequestMapping("/test")
public class TestController {
    
    @Autowired
    PersonService personSvc;

    @ResponseBody
    @GetMapping("/add")
    public String addPerson() {
        Person p = new Person(1, "darryl", "darryl@nus.edu.sg");
        personSvc.addPerson("persons", p);
        p = new Person(2, "chuk", "chuk@nus.edu.sg");
        personSvc.addPerson("persons", p);
        p = new Person(3, "kenneth", "kenneth@nus.edu.sg");
        personSvc.addPerson("persons", p);
    
        return "added persons successfully";
    }
    
    @GetMapping("/persons")
    public String personFindAll(Model model) {
        model.addAttribute("persons", personSvc.findAll("persons"));
        return "personlist";
    }
    
    @ResponseBody
    @GetMapping("/delete")
    public Boolean deletePerson() {
        Person p = new Person(3, "kenneth", "kenneth@nus.edu.sg");
        return personSvc.delete("persons", p);
    }
      
}
