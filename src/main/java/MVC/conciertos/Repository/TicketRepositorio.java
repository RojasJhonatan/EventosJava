package MVC.conciertos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MVC.conciertos.Model.TicketModel;

@Repository
public interface TicketRepositorio extends JpaRepository<TicketModel, Integer> {
  
}
