package MVC.conciertos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MVC.conciertos.Model.EventoModel;
import MVC.conciertos.Service.EventoService;

@RestController
@RequestMapping("/eventos")

public class EventoControlador{

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<EventoModel> buscarTodosEventos(){
        return eventoService.buscarTodosEventos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoModel> buscarEventoPorId(@PathVariable Integer id){
        return eventoService.buscarEventoPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());        
    }

    @PostMapping
    public ResponseEntity<EventoModel> crearEvento(@RequestBody EventoModel evento){
        EventoModel nuevoEvento = eventoService.crearEvento(evento);
        return ResponseEntity.ok(nuevoEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoModel> actualizarEvento(@PathVariable Integer id, @RequestBody EventoModel evento){
        try {
            EventoModel eventoActualizado = eventoService.actualizarEvento(id, evento);
            return ResponseEntity.ok(eventoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } 
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable Integer id){
        if(eventoService.eliminarEvento(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
