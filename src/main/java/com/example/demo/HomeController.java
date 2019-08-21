package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    CarRepository repository;

    @RequestMapping("/")
    public String listCars(Model model){
        model.addAttribute("cars", repository.findAll());
        return "list";
    }

    @RequestMapping("/add")
    public String carForm(Model model){
        model.addAttribute("car", new Car());
        return "carForm";
    }

    @RequestMapping("/process")
    public String processForm(@Valid Car car, BindingResult result){
        if (result.hasErrors()){
            return "carForm";
        }
        repository.save(car);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCars(@PathVariable("id") long id, Model model){
        model.addAttribute("car", repository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCars(@PathVariable("id") long id, Model model){
        model.addAttribute("car", repository.findById(id).get());
        return "carForm";
    }

    @RequestMapping("/delete/{id}")
    public String delCars(@PathVariable("id") long id){
        repository.deleteById(id);
        return "redirect:/";
    }
}
