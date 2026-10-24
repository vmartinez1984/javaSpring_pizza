package mx.unam.aragon.tsp.vmartinez.pizzas.webController;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import mx.unam.aragon.tsp.vmartinez.pizzas.businessLayer.PizzasBusinessLayer;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.PizzaDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.PizzaDtoIn;

import org.springframework.web.bind.annotation.GetMapping;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller 
public class PizzaWebController {

    private  PizzasBusinessLayer pizzasBusinessLayer;

    public PizzaWebController(PizzasBusinessLayer businessLayer) {
        this.pizzasBusinessLayer = businessLayer;
    }

    @GetMapping("/pizzas")
    public String index(Model model ) {
        List<PizzaDto> pizzas;

        pizzas = pizzasBusinessLayer.obtenerTodas();
        model.addAttribute("pizzas", pizzas);

        return "pizzas/index";
    }

    @GetMapping("/pizzas/crear")
    public String crear(Model model) {
        model.addAttribute("pizzaDtoIn", new PizzaDtoIn());

        return "pizzas/crear";
    }

    @PostMapping("/pizzas/crear")
    public String guardar(PizzaDtoIn pizzaDtoIn) {
        pizzasBusinessLayer.Agregar(pizzaDtoIn);
        
        return "redirect:/pizzas";
    }
    
    @GetMapping("/pizzas/editar/{id}")
    public String crear(@PathParam("id") int id) {
        return "pizzas/editar";
    }

    @PostMapping("/pizzas/actualizar/{id}")
    public String actualizar(@PathParam("id") int id, @RequestBody PizzaDtoIn pizzaDtoIn) {
        pizzasBusinessLayer.actualizar(id, pizzaDtoIn);
        
        return "";
    }
    
}