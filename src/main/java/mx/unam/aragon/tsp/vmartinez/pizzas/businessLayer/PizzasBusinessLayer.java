package mx.unam.aragon.tsp.vmartinez.pizzas.businessLayer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.IdDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.PizzaDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.PizzaDtoIn;

/**
 * Es la clase donde estan las reglas de negocio
 * PizzasBusinessLayer
 */
@Service
public class PizzasBusinessLayer {


    /**
     * Regresa una lista de pizzas
     * @return ArrayList<PizzaDto>
     */
    public List<PizzaDto> obtenerTodas(){                
        List<PizzaDto> pizzas = new ArrayList<>();
        //Conexión a la db para obtener la pizzas de la tabla pizzas en estado activo = true
        //Mapeo de pizzaEntidad a la pizzaDto
        //pizzas.add(new PizzaDto(1,"Hawwaiina", "Jamón, piña y queso", 120));
        //pizzas.add(new PizzaDto(2, "Mexicana", "Jalapeño, carne molida y queso", 130));        

        return  pizzas;
    }

    public IdDto Agregar(PizzaDtoIn pizzaDtoIn){
        
        return  new IdDto(1, "Datos registrados");
    }

    public PizzaDto obtenerPorId(int id){        
        return new PizzaDto();
    }

    public void actualizar(int id, PizzaDtoIn pizzaDtoIn){
        //Obterner la pizza de la db por el id
        //Actualizar los campos con los datos de la pizzaDtoIn
        //Guardamos los cambios
    }

    public void borrar(int id){
        //desactivar y guaurdar
    }
}
