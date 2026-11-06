package mx.unam.aragon.tsp.vmartinez.pizzas.businessLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.ClienteDtoIn;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.IdDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.entities.ClienteEntity;
import mx.unam.aragon.tsp.vmartinez.pizzas.repositories.IClienteRepository;

@Service 
public class ClienteBusinessLayer {

    @Autowired 
    IClienteRepository repository;

    public IdDto agregar(ClienteDtoIn clienteDtoIn){
        ClienteEntity clienteEntity = clienteDtoIn.toEntity();
        clienteEntity = repository.save(clienteEntity);

        return new IdDto(clienteEntity.getId(), "Cliente registrado");
    }

    public boolean existe(ClienteDtoIn clienteDtoIn){
        ClienteEntity entity = repository.findByCorreoOrGuid(
            clienteDtoIn.getCorreo(), clienteDtoIn.getGuid()
        ).orElse(null);
        return entity != null;        
    }

}
