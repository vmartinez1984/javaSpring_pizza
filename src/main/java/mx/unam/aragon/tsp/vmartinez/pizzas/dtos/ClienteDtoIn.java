package mx.unam.aragon.tsp.vmartinez.pizzas.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mx.unam.aragon.tsp.vmartinez.pizzas.entities.ClienteEntity;

@Getter 
@Setter 
@AllArgsConstructor 
public class ClienteDtoIn {
    @NotBlank(message = "El guid no puede ser vacio")
    private String guid;
    
    @NotBlank(message = "El nombre no puede ser vacio")
    @Size(max = 64, message = "El guid no puede superar los 64 caracteres", min = 3)
    private String nombre;
    
    private String apellidoPaterno;

    private String apellidoMaterno;    
 
    private LocalDate fechaDeNacimiento;
    
    private String correo;

    private String contrasenia;

    public ClienteEntity toEntity(){
        return new ClienteEntity(0, 
            guid, 
            nombre, 
            apellidoMaterno, 
            apellidoPaterno, 
            fechaDeNacimiento,
            correo,
            contrasenia,
             true);
    }

}
