package MVC.conciertos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MVC.conciertos.Model.EventoModel;

@Repository
public interface EventoRepositorio extends JpaRepository<EventoModel,Integer> {
    
}
