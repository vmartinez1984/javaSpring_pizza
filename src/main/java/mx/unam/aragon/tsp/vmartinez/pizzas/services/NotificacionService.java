package mx.unam.aragon.tsp.vmartinez.pizzas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.vmartinez.pizzas.core.services.INotificacionService;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.IdDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.NotificacionDto;

@Service 
public class NotificacionService implements INotificacionService {
    String correo = "notificacion@vmartinez84.xyz";
    //String contrasenia = "7Pnc%k589";

    @Autowired //Con esto carnalit@ se hace la inyección de dependencias
    private JavaMailSender mailSender;

    @Override
    public IdDto EnviarCorreo(NotificacionDto notificacionDto){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            
            simpleMailMessage.setFrom(correo);
            simpleMailMessage.setTo(notificacionDto.getDestino());
            simpleMailMessage.setSubject("Notificación :)");
            simpleMailMessage.setText(notificacionDto.getMensaje());
            mailSender.send(simpleMailMessage);

            return new  IdDto(0, "Correo enviado");
        } catch (Exception e) {
            // TODO: handle exception
            return  new IdDto(-1, e.getMessage());
        }
    }
}
