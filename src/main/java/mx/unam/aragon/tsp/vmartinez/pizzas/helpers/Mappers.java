package mx.unam.aragon.tsp.vmartinez.pizzas.helpers;

import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.PizzaDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.entities.PizzaEntity;

public class Mappers {
    public static PizzaDto ToDto(PizzaEntity entity){
        return  new PizzaDto(
            entity.getId(), 
            entity.getNombre(), 
            entity.getDescripcion(), 
            entity.getPrecio());
    }
}
