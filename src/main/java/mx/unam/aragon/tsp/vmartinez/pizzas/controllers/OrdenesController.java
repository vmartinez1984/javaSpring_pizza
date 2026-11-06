package mx.unam.aragon.tsp.vmartinez.pizzas.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mx.unam.aragon.tsp.vmartinez.pizzas.businessLayer.OrdenBusinessLayer;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.IdDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.OrdenDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.OrdenDtoIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class OrdenesController {

    @Autowired 
    OrdenBusinessLayer businessLayer;

    @PostMapping("/ordenes")
    public ResponseEntity agregar(@Valid @RequestBody OrdenDtoIn ordenDtoIn) {
       boolean existe = businessLayer.exists(ordenDtoIn.getGuid());
       if(existe)
            return ResponseEntity.status(208).body(new IdDto(0, "Orden previamente registrada"));

        IdDto idDto = businessLayer.agregar(ordenDtoIn);
        
        return ResponseEntity.status(201).body(idDto);
    }

    @PutMapping("/ordenes/{guid}/{estado}")
    public ResponseEntity actualizarEstado(@PathVariable String guid, @PathVariable String estado) {
        businessLayer.updateState(guid, estado);
        
        return ResponseEntity.status(202).body(new IdDto(0, "Estado actualizado"));
    }
    
 
    @GetMapping("/ordenes/{guid}")
    public ResponseEntity obtenerPorGuid(@PathVariable String guid) {
        OrdenDto ordenDto = businessLayer.get(guid);
        
        return ResponseEntity.status(200).body(ordenDto);
    }
}