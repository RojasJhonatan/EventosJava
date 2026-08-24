package MVC.conciertos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    @Email(message = "El formato de email no es válido")
    @NotBlank(message = "Debe ingresar un email")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacia")
    private String password;
}
