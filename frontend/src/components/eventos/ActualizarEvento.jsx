import { useParams } from "react-router-dom";

function ActualizarEvento(){
    const {id}=useParams();
    return(
        <div>
            <h1>Actualizar Evento</h1>
            <p>ID Evento:{id}</p>
        </div>
    );
}
export default ActualizarEvento;