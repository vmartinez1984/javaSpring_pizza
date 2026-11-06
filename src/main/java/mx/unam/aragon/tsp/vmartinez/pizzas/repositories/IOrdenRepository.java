package mx.unam.aragon.tsp.vmartinez.pizzas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.unam.aragon.tsp.vmartinez.pizzas.entities.OrdenEntity;

public interface IOrdenRepository extends  JpaRepository<OrdenEntity, Integer>{

    Optional<OrdenEntity> findByGuid(String guid);
}
