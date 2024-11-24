package sg.edu.nus.iss.vttp5a_day5l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import sg.edu.nus.iss.vttp5a_day5l.model.Person;
import sg.edu.nus.iss.vttp5a_day5l.service.PersonService;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/tests")
public class TestController {
    
    @Autowired
    PersonService personSvc;

    @ResponseBody
    @GetMapping("/add")
    public String addPerson() {
        Person p = new Person(1, "Darryl Ng", "darryl@nus.edu.sg");
        personSvc.addPerson("persons", p);
        p = new Person(2, "Chuk Munn Lee", "chuk@nus.edu.sg");
        personSvc.addPerson("persons", p);
        p = new Person(3, "Kenneth Pang", "kennethp@nus.edu.sg");
        personSvc.addPerson("persons", p);

        return "Person added successfully!";
    }
    

    @GetMapping("/persons")
    public String personFindAll(Model model) {
        List<Person> persons = personSvc.findAll("persons");
        model.addAttribute("persons", persons);
        return "persons";
    }

    // @ResponseBody
    // @GetMapping("/delete")
    // public Boolean deletePerson() {
    //     Person p = new Person(3, "Kenneth Pang", "kennethp@nus.edu.sg");
    //     return personSvc.delete("persons", p);
    // }
    
    @GetMapping("/create")
    public String getPersonForm(Model model) {
        Person p = new Person();
        model.addAttribute("person", p);
        return "addPersonForm";
    }

    @PostMapping("/create")
    public String handleNewPersonForm(@Valid Person person, BindingResult result,
    Model model) {
        if (result.hasErrors()){
            return "addPersonForm";
        }
        
        Person p = new Person(person.getId(), person.getFullName(), person.getEmail());
        // System.out.println(p);
        personSvc.addPerson("persons", p);
        
        return "redirect:/tests/persons";
    }
}
