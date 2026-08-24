package MVC.conciertos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RolStatus {

    ADMIN("Admin"), USUARIO("Usuario"), INVITADO("Invitado");
    private final String descripcion;
}
