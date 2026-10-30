package mx.unam.aragon.tsp.vmartinez.pizzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import mx.unam.aragon.tsp.vmartinez.pizzas.entities.PizzaEntity;

public interface IPizzaRepository extends JpaRepository<PizzaEntity, Integer> {}