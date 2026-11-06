package mx.unam.aragon.tsp.vmartinez.pizzas.entities;

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
@Table(name = "orden")
public class OrdenEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length = 64)
    private String guid;

    @Column(nullable = false)
    private int clienteId;

    @Column(nullable = false, length = 64)
    private String state;

    @Column(nullable = false)
    private String pizzaId;
}