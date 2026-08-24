package MVC.conciertos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MVC.conciertos.Model.TicketModel;
import MVC.conciertos.Service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketControlador {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<TicketModel> buscarTodosTickets(){
        return ticketService.buscarTodosTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketModel> buscarTicketPorId(@PathVariable Integer id){
        return ticketService.buscarTicketPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TicketModel> crearTicket(@RequestBody TicketModel ticketModel){
        TicketModel nuevoTicket = ticketService.crearTicket(ticketModel);
        return ResponseEntity.ok(nuevoTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable Integer id){
        if(ticketService.borrarTicket(id)){
            ticketService.borrarTicket(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}

