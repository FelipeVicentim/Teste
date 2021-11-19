package com.wsteste.atividade01.resources;

import com.wsteste.atividade01.model.Factories;
import com.wsteste.atividade01.repository.FactoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class FactoriesResource {

    @Autowired
    private FactoriesRepository factoriesRepository;

    @GetMapping("factories")
    public List<Factories> listFactories(){
        return factoriesRepository.findAll();
    }

    @GetMapping("/factory/{id}")
    public Factories factoryById(@PathVariable(value = "id") long id){
        return factoriesRepository.findById(id);
    }

    @PostMapping("/factory")
    public Factories saveFactory(@RequestBody Factories factory){
        return factoriesRepository.save(factory);
    }

    @DeleteMapping("/factory")
    public void deleteFactory(@RequestBody Factories factory){
        factoriesRepository.delete(factory);
    }

    @PutMapping("/factory")
    public Factories putFactory(@RequestBody Factories factory){
        return factoriesRepository.save(factory);
    }
}
