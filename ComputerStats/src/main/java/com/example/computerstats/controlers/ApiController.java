package com.example.computerstats.controlers;


import com.example.computerstats.models.Computer;
import com.example.computerstats.repositries.ComputerRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ApiController {


    public ComputerRepository repository;

    public ApiController(ComputerRepository repository){
        this.repository = repository;
    }

    @PostMapping("/add/data")
    public Map<String, String> addData(@RequestBody String data) {
        String [] tokens = data.split("&");
        Computer computer = null;
        for (String token : tokens) {
            String [] values = token.split("=");
            if(values[0].equals("id")) {
                Optional<Computer> optional = repository.findById(Long.parseLong(values[1]));
                if(optional.isPresent()) {
                    computer = optional.get();
                }
                else {
                    computer = new Computer();
                    computer.setId(Long.parseLong(values[1]));
                }
            }
            else {
                computer.setProperty(values[0], values[1]);
            }
            System.out.println(values[0] + ": " + values[1]);
        }
        if(computer != null) {
            repository.save(computer);
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("Result", "success");
        return map;
    }
}
