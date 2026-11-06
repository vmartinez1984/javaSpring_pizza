package mx.unam.aragon.tsp.vmartinez.pizzas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.unam.aragon.tsp.vmartinez.pizzas.entities.PizzaEntity;

public interface IPizzaRepository extends JpaRepository<PizzaEntity, Integer> {
    Optional<PizzaEntity> findByGuid(String guid);

    boolean existsByGuid(String guid);
}