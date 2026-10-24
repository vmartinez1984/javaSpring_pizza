package mx.unam.aragon.tsp.vmartinez.pizzas.controllers;

import org.springframework.web.bind.annotation.RestController;

import mx.unam.aragon.tsp.vmartinez.pizzas.core.services.INotificacionService;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.IdDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.NotificacionDto;
import mx.unam.aragon.tsp.vmartinez.pizzas.dtos.SaludoDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired 
    INotificacionService notificacionService;

    @PostMapping("/Test/Notificaciones")
    public IdDto EnviarNotificacion(@RequestBody NotificacionDto notificacionDto) {        
        IdDto idDto = notificacionService.EnviarCorreo(notificacionDto);

        return idDto;
    }
    
    @GetMapping("/Test/Saludar")
    public IdDto saludarGet(@RequestParam SaludoDto  saludo) {
        return new IdDto(0, "Hola mundo, " + saludo.getMensaje());
    }

    @PostMapping("/Test/Saludar")
    public IdDto saludarPost(@RequestBody SaludoDto saludoDto) {       
        return new IdDto(0, "Hola mundo, " +saludoDto.getMensaje());
    }
    
    @GetMapping("/Test/StatusCode/{code}")
    public ResponseEntity<IdDto> getMethodName(@PathVariable ("code") String code) {
        if("404".equals(code)){
            IdDto idDto = new IdDto(404, "Nel carnal, pero el lunes sin falta");
            return ResponseEntity.status(404).body(idDto);
        }

        IdDto idDto = new IdDto(Integer.parseInt(code), "Todo chido carnalito");

        return ResponseEntity.status(404).body(idDto);
    }
    
    @GetMapping("/Test/timeout")
    public ResponseEntity<IdDto> timeOut() {        
       
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
        .body(new IdDto(500, "Valio rata carnalito"));
    }
    
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/procesar/{valor}")
    public ResponseEntity<String> procesarValor(@PathVariable String valor) {
        try {
            // Simulamos una conversión que fallará si envías letras
            int numero = Integer.parseInt(valor);
            return ResponseEntity.ok("Número procesado: " + numero);
            
        } catch (NumberFormatException e) {
            // ❌ MAL: logger.error("Ocurrió un error: " + e.getMessage()); 
            // (Pierdes la trazabilidad exacta de dónde ocurrió el error en las líneas de código).

            // ✅ BIEN: Pasamos la excepción 'e' como último argumento
            logger.error("Error al intentar convertir el valor '{}' a un número entero", valor, e);
            
            return ResponseEntity.badRequest().body("El valor ingresado no es válido.");
        }
    }
}
