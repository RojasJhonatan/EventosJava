package MVC.conciertos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MVC.conciertos.Model.TicketModel;
import MVC.conciertos.Repository.TicketRepositorio;

@Service
public class TicketService {
    
    @Autowired
    private TicketRepositorio ticketRepositorio;

    public List<TicketModel> buscarTodosTickets(){
        return ticketRepositorio.findAll();
    }

    public Optional<TicketModel> buscarTicketPorId(Integer id){
        return ticketRepositorio.findById(id);
    }

    public TicketModel crearTicket(TicketModel ticketModel){
        return ticketRepositorio.save(ticketModel);
    }

    public boolean borrarTicket(Integer id){
        if(ticketRepositorio.existsById(id)){
            ticketRepositorio.deleteById(id);
            return true;
        }else{
            return false;
        }
    } 
}
