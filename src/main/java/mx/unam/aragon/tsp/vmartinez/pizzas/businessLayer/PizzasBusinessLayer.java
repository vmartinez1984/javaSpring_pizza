package mx.unam.aragon.tsp.vmartinez.pizzas.businessLayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.IdDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.PizzaDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.PizzaDtoIn;
import mx.unam.aragon.tsp.vmartinez.pizzas.entities.PizzaEntity;
import mx.unam.aragon.tsp.vmartinez.pizzas.repositories.IPizzaRepository;

/**
 * Es la clase donde estan las reglas de negocio
 * PizzasBusinessLayer
 */
@Service
public class PizzasBusinessLayer {

    @Autowired 
    IPizzaRepository repository;

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
        List<PizzaEntity> entities = repository.findAll();
        for (PizzaEntity pizzaEntity : entities) {
            pizzas.add(
                new PizzaDto(
                    pizzaEntity.getId(), 
                    pizzaEntity.getNombre(),
                    pizzaEntity.getDescripcion(), 
                    pizzaEntity.getPrecio())
                );
        }

        return  pizzas;
    }

    public IdDto Agregar(PizzaDtoIn pizzaDtoIn){
        PizzaEntity entity = new PizzaEntity(
            0,
            pizzaDtoIn.getNombre(),
            pizzaDtoIn.getDescripcion(),
            pizzaDtoIn.getPrecio(),
            true
        );
        PizzaEntity pizzaEntity = repository.save(entity);

        return  new IdDto(pizzaEntity.getId(), "Datos registrados");
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
