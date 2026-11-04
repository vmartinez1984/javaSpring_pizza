package mx.unam.aragon.tsp.vmartinez.pizzas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@AllArgsConstructor
@NoArgsConstructor 
public class PizzaDtoIn {
    String nombre;
    String descripcion;
    double precio;
    String guid;     
}
