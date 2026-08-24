package MVC.conciertos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import MVC.conciertos.Model.UsuarioModel;
import MVC.conciertos.Repository.UsuarioRepositorio;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UsuarioModel> obtenerTodosUsuarios(){
        return usuarioRepositorio.findAll();
    }
    
    public Optional<UsuarioModel> buscarPorId(Integer id) {
        return usuarioRepositorio.findById(id);
    }

    public UsuarioModel crearUsuario(UsuarioModel usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepositorio.save(usuario);
    }

    public UsuarioModel actualizUsuario(Integer id, UsuarioModel usuarioActualizado){
        return usuarioRepositorio.findById(id)
        .map(usuarioExistente->{
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
            usuarioExistente.setEmail(usuarioActualizado.getEmail());

            if (usuarioActualizado.getPassword() != null && !usuarioActualizado.getPassword().isEmpty()) {
                usuarioExistente.setPassword(
                 passwordEncoder.encode(usuarioActualizado.getPassword())
                );
            }

            usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
            usuarioExistente.setRol(usuarioActualizado.getRol());
            return usuarioRepositorio.save(usuarioExistente);
        })
        .orElseThrow(()-> new RuntimeException("Usuario No Encontrado con id "+id));
    }

    public boolean eliminarUsuario(Integer id){
        if(usuarioRepositorio.existsById(id)){
            usuarioRepositorio.deleteById(id);
            return true;
        }
        return false;
    }

    public UsuarioModel autenticarUsuario(String email,String contraseñaPlana){
        UsuarioModel usuario = usuarioRepositorio.findByEmail(email)
        .orElseThrow(()-> new RuntimeException("Usuario NO encontrado"));
        boolean validacion = passwordEncoder.matches(contraseñaPlana, usuario.getPassword());
        if (!validacion){
            throw new RuntimeException("Contraseña Incorrecta");            
        }
        return usuario;

    }
}
