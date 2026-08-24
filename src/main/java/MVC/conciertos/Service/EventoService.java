package MVC.conciertos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MVC.conciertos.Model.EventoModel;
import MVC.conciertos.Repository.EventoRepositorio;

@Service
public class EventoService {
    @Autowired
    private EventoRepositorio eventoRepositorio;

    public List<EventoModel> buscarTodosEventos(){
        return eventoRepositorio.findAll();        
    }

    public Optional<EventoModel> buscarEventoPorId(Integer id){
        return eventoRepositorio.findById(id);
    }

    public EventoModel crearEvento(EventoModel evento){
        return eventoRepositorio.save(evento);
    }

    public EventoModel actualizarEvento( Integer id,EventoModel evento){
        return eventoRepositorio.findById(id)
        .map(eventoExistente->{
            eventoExistente.setTitulo(evento.getTitulo());
            eventoExistente.setDescripcion(evento.getDescripcion());
            eventoExistente.setCapacidadMax(evento.getCapacidadMax());
            eventoExistente.setFechaHora(evento.getFechaHora());
            eventoExistente.setLugar(evento.getLugar());
            eventoExistente.setPrecioBase(evento.getPrecioBase());
            eventoExistente.setEstado(evento.getEstado());
            return eventoRepositorio.save(eventoExistente);
        })
        .orElseThrow(()-> new RuntimeException("Usuario "+id+" NO encontrado"));
    }

    public boolean eliminarEvento(Integer id){
        if(eventoRepositorio.existsById(id)){
            eventoRepositorio.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
}
