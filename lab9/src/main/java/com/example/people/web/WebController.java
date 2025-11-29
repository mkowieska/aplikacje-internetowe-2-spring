package com.example.people.web;

import com.example.people.model.Person;
import com.example.people.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
    private final PersonService personService;

    public WebController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping({"/","/people"})
    public String people(Model model) {
        model.addAttribute("people", personService.getPeople());
        return "people"; 
    }

    @GetMapping("/person/{index}")
    public String person(@PathVariable int index, Model model) {
        personService.getPerson(index).ifPresentOrElse(
            p -> model.addAttribute("person", p),
            () -> model.addAttribute("notFound", true)
        );
        model.addAttribute("index", index);
        return "person";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("person", new Person());
        return "form"; 
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute Person person) {
        personService.addPerson(person);
        return "redirect:/people";
    }
}