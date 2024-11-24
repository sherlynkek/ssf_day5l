package sg.edu.nus.iss.vttp5a_day5l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.vttp5a_day5l.model.Person;
import sg.edu.nus.iss.vttp5a_day5l.service.PersonService;
import sg.edu.nus.iss.vttp5a_day5l.util.Util;

@Controller
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    PersonService personService;

    @GetMapping("")
    public String personListPage(Model model) {

        List<Person> persons = personService.findAll(Util.keyPerson);
        model.addAttribute("persons", persons);
        
        return "personlist";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        Person p = new Person(1, "", null);
        model.addAttribute("person", p);

        return "personcreate";
    }
    
    @PostMapping("/create")
    public String createPersonRecord(@ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {
        personService.addPerson(Util.keyPerson, person);

        return "redirect:/persons";
    }
    
    @GetMapping("/delete/{person-id}")
    public String deletePersonRecord(@PathVariable("person-id") String personId) {
        // logic 
        // other shift the logic to service layer

        return "redirect:/persons";
    }
}
