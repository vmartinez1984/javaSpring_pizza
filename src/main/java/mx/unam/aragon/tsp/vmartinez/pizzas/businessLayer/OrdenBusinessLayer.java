package mx.unam.aragon.tsp.vmartinez.pizzas.businessLayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.IdDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.OrdenDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.OrdenDtoIn;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.PizzaDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.entities.ClienteEntity;
import mx.unam.aragon.tsp.vmartinez.pizzas.entities.OrdenEntity;
import mx.unam.aragon.tsp.vmartinez.pizzas.entities.PizzaEntity;
import mx.unam.aragon.tsp.vmartinez.pizzas.repositories.IClienteRepository;
import mx.unam.aragon.tsp.vmartinez.pizzas.repositories.IOrdenRepository;
import mx.unam.aragon.tsp.vmartinez.pizzas.repositories.IPizzaRepository;

@Service 
public class OrdenBusinessLayer {

    @Autowired 
    IClienteRepository clienteRepository;
    @Autowired
    IOrdenRepository ordenRepository;
    @Autowired
    IPizzaRepository pizzaRepository;

    public IdDto agregar(OrdenDtoIn ordenDtoIn){
        ClienteEntity clienteEntity = clienteRepository.findByGuid(ordenDtoIn.getClienteGuid()).orElse(null);
        String pizzaIds = ordenDtoIn.getPizzaIds().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        OrdenEntity ordenEntity = new OrdenEntity(
                0,
                ordenDtoIn.getGuid(),
                clienteEntity.getId(),
                "Orden registrada",
                pizzaIds
            );
            ordenRepository.save(ordenEntity);
        
        return new IdDto(0, "Orden registrada");
    }

    public void updateState(String guid, String estado) {
        OrdenEntity entity = ordenRepository.findByGuid(guid).orElse(null);        
        entity.setState(estado);
        ordenRepository.save(entity);
    }

    public OrdenDto get(String guid){
        OrdenEntity entity = ordenRepository.findByGuid(guid).orElse(null);
        if(entity == null)
            return  null;
        OrdenDto dto = new OrdenDto();
        dto.setClienteGuid(entity.getGuid());
        dto.setGuid(guid);
        dto.setEstado(entity.getState());
        List<Integer> listaIds = Arrays.stream(entity.getPizzaId().split(","))
                .map(String::trim)           // Limpia espacios (" 5" -> "5")
                .map(Integer::valueOf)       // Convierte cada String a Integer
                .collect(Collectors.toList()); // Agrupa en una lista
        List<PizzaDto> pizzaDtos = new ArrayList<PizzaDto>();
        for (int pizzaId : listaIds) {
            PizzaEntity pizzaEntity= pizzaRepository.findById(pizzaId).orElse(null);
            pizzaDtos.add(pizzaEntity.toDto());
        }
        dto.setPizzas(pizzaDtos);

        return dto;
    }

    public boolean exists(String guid){
        OrdenEntity entity = ordenRepository.findByGuid(guid).orElse(null);
        
        return entity != null;
    }
}
