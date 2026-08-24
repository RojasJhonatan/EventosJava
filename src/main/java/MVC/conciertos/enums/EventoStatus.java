package MVC.conciertos.enums;

import lombok.*;

@AllArgsConstructor
@Getter

public enum EventoStatus {

    AGOTADO("Agotado"), DISPONIBLE("Disponible"), CERRADO("Cerrado");

    private final String descripcion; 
    
}
