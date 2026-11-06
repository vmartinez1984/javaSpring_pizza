package mx.unam.aragon.tsp.vmartinez.pizzas.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class OrdenDtoIn {
        
    @NotBlank(message = "El guid es obligatorio")
    @Size(max = 64, message = "El guid no puede superar los 64 caracteres")
    private String guid;
    
    @NotBlank(message = "El guid es obligatorio")
    @Size(max = 64, message = "El guid no puede superar los 64 caracteres")
    private String clienteGuid;
    
    private List<Integer> pizzaIds;
}
