package mx.unam.aragon.tsp.vmartinez.pizzas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.unam.aragon.tsp.vmartinez.pizzas.entities.PizzaEntity;

public interface IPizzaRepository extends JpaRepository<PizzaEntity, Integer> {

    //@Query("SELECT p FROM pizzas p WHERE p.guid = ?1")
    //PizzaEntity obtenerPorGuid(String guid);

    Optional<PizzaEntity> findByGuid(String guid);
}