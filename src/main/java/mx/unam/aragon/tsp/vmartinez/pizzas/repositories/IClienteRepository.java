package mx.unam.aragon.tsp.vmartinez.pizzas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.unam.aragon.tsp.vmartinez.pizzas.entities.ClienteEntity;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Integer>  {

    //El nombre no es el de la tabla si no de la clase java
    /**
     * buscar un cliente por correo o por guid
     * @param correo
     * @param guid
     * @return ClienteEntity
     */
    @Query("SELECT c FROM ClienteEntity c WHERE c.correo = ?1 OR c.guid = ?2")   
    Optional<ClienteEntity> findByCorreoOrGuid(String correo, String guid);

    Optional<ClienteEntity> findByGuid(String guid);
}
