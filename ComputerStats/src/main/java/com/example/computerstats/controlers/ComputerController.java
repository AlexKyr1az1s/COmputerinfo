package com.example.computerstats.controlers;

import com.example.computerstats.models.Computer;
import com.example.computerstats.repositries.ComputerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class ComputerController {



    public ComputerRepository repository;

    public ComputerController(ComputerRepository repository){
        this.repository = repository;
    }
    @GetMapping("/")
    public String home() {
        return "home";

    }
 @GetMapping("/stats")
    public String stats(Model model){
        model.addAttribute("data",repository.findAll());
        return "stats";

    }

    @GetMapping("/computers")
    public String computers(Model model){
        model.addAttribute("data",repository.findAll());
        return "computers";

    }

    @GetMapping("/computer/{id}")
    public String computer(Model model, @PathVariable(value="id") String id){
        Long cid = Long.parseLong(id);
        Computer computer = null;
        Optional<Computer> optional = repository.findById(cid);
        if(optional.isPresent())  {
            computer = optional.get();
            model.addAttribute("computer", computer);
            return "computer";
        }
        else {
            return "error404";
        }


    }






}
