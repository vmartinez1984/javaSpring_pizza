package mx.unam.aragon.tsp.vmartinez.pizzas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.aragon.tsp.vmartinez.pizzas.businessLayer.PizzasBusinessLayer;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.IdDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.PizzaDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.PizzaDtoIn;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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

    @PostMapping("/api/v1/pizzas")
    public IdDto guardarDto(PizzaDtoIn pizzaDtoIn) {
        IdDto idDto = pizzasBusinessLayer.Agregar(pizzaDtoIn);
        
        return idDto;
    }
    
    
}