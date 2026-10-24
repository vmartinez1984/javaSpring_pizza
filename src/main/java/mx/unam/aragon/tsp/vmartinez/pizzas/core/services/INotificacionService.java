package mx.unam.aragon.tsp.vmartinez.pizzas.core.services;

import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.IdDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.NotificacionDto;

public interface INotificacionService {
    public IdDto EnviarCorreo(NotificacionDto notificacionDto); 
}
