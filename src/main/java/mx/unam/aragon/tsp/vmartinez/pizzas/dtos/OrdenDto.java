package mx.unam.aragon.tsp.vmartinez.pizzas.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class OrdenDto {
    private String guid;        
    private String clienteGuid;    
    private List<PizzaDto> pizzas;
    private String estado;
}
