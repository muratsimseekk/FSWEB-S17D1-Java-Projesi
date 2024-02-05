package com.workintech.springinitial.springbasics.controller;

import com.workintech.springinitial.springbasics.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/animal")
@RestController
public class AnimalController {

    private Map<Integer , Animal> animals = new HashMap<>();



    @GetMapping("/")
    public List<Animal> findAll () {
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
   public Animal findById (@PathVariable int id) {
        return animals.get(id);
   }

    @PostMapping("/")  // /animal/  endpointine post islemi
    public Animal save(@RequestBody Animal animal){
        animals.put(animal.getId() , animal);

        return animals.get(animal.getId());
    }

    @PutMapping("/{id}")
    public Animal update(@RequestBody Animal animal , @PathVariable int id)
    {
        animals.put(id , new Animal(id , animal.getName()));
        return  animals.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal remove (@PathVariable int id ){
        Animal animal = animals.get(id);

        animals.remove(id);

        return animal;
    }

}
