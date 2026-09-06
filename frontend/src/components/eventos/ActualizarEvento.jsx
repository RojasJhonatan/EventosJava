import { useParams } from "react-router-dom";
import FormularioEvento from "./FormularioEvento";

function ActualizarEvento(){
    const {id}=useParams();
    return(
        <div>
            <h1>Actualizar Evento</h1>
            <p>ID Evento: {id}</p>
            <FormularioEvento/>
        </div>
    );
}
export default ActualizarEvento;