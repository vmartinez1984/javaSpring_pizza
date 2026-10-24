package mx.unam.aragon.tsp.vmartinez.pizzas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.aragon.tsp.vmartinez.pizzas.businessLayer.PizzasBusinessLayer;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.PizzaDto;


@RestController
public class PizzaController {
    
    private  PizzasBusinessLayer pizzasBusinessLayer;

    public PizzaController(PizzasBusinessLayer businessLayer) {
        this.pizzasBusinessLayer = businessLayer;
    }

    @GetMapping("/api/v1/pizzas")        
    public List<PizzaDto> obtenerTodas(){
        List<PizzaDto> pizzas;

        pizzas = pizzasBusinessLayer.obtenerTodas();

        return pizzas;
    }
    
}