package mx.unam.aragon.tsp.vmartinez.pizzas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import mx.unam.aragon.tsp.vmartinez.pizzas.businessLayer.ClienteBusinessLayer;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.ClienteDtoIn;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.IdDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController 
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired 
    ClienteBusinessLayer businessLayer;

    @PostMapping("/clientes")
    public ResponseEntity agregar(@Valid @RequestBody  ClienteDtoIn clienteDtoIn) {
        boolean existe = businessLayer.existe(clienteDtoIn);
        if(existe)
            return ResponseEntity.status(208).body(
                new IdDto(0, "guid o correo registrados previamente")
            );

        IdDto dto = businessLayer.agregar(clienteDtoIn);
        
        return ResponseEntity.status(201).body(dto);
    } 
    
}
