package mx.unam.aragon.tsp.vmartinez.pizzas.entities;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@AllArgsConstructor 
@NoArgsConstructor 
@Entity 
@Table(name = "cliente")
public class ClienteEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length = 64)
    private String guid;

    @Column(nullable = false, length = 64)
    private String nombre;

    @Column(nullable = false, length = 64)
    private String apellidoMaterno;
    
    private String apellidoPaterno;

    @Column(nullable = false)
    private LocalDate fechaDeNacimiento;

    @Column(nullable = false, length = 64)
    private String correo;

    @Column(nullable = false, length = 64)
    private String contrasenia;

    @Column(nullable = false)
    private boolean activo;
}
