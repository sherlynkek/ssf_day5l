package sg.edu.nus.iss.vttp5a_day5l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/add")
    public String addPerson() {
        Person p = new Person(1, "paige", "abc@def.com");
        personSvc.addPerson("persons", p);
        p = new Person(2, "hijau", "teh@def.com");
        personSvc.addPerson("persons", p);
        p = new Person(3, "maven", "java@def.com");
        personSvc.addPerson("persons", p);
    
        return "added persons successfully";
    }
    
    @ResponseBody
    @GetMapping("/persons")
    public List<Person> personFindAll() {
       
        return personSvc.findAll("persons");
    }
    
    @ResponseBody
    @GetMapping("/delete")
    public Boolean deletePerson(Person person) {
        return personSvc.delete("persons", person);
    }
    

}
