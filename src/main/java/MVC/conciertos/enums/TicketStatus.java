package MVC.conciertos.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor

public enum TicketStatus {
    PENDIENTE("Pendiente"), PAGADO("Pagado"), CANCELADO("Cancelado");
    private final String descripcion;
}
