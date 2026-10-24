package mx.unam.aragon.tsp.vmartinez.pizzas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
public class NotificacionDto {
    private String destino;
    private String mensaje;
}
