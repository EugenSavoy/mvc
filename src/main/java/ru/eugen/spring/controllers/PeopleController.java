package ru.eugen.spring.controllers;

import jakarta.validation.Valid;
import javafx.beans.binding.Binding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.eugen.spring.dao.PersonDao;
import ru.eugen.spring.model.People;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new People());
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid People people, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "redirect:/people";

        personDao.save(people);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDao.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid People people, BindingResult bindingResult, @PathVariable("id") int id){

        if (bindingResult.hasErrors())
            return "redirect:/people";

        personDao.update(id, people);
        return "redirect:/people";
    }

    @GetMapping("/{id}/delete")
    public String edit2(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDao.show(id));
        return "people/delete";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDao.delete(id);
        return "redirect:/people";
    }

}
