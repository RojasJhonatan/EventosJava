package MVC.conciertos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MVC.conciertos.Model.UsuarioModel;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioModel,Integer>{
    
    Optional<UsuarioModel> findByEmail(String email);
}
