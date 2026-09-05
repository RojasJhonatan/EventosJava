import { useEffect, useState } from "react";
import { obtenerEventos,eliminarEvento } from "../../service/eventoService";


function ListaEventos() {
    const [eventos, setEventos] = useState([]);

    useEffect(() => {
        cargarEventos();
    },[]);

    const cargarEventos = async() => {
        try {
            const datos = await obtenerEventos();
            setEventos(datos);
        } catch (error) {
            console.error("Error al cargar los eventos: ",error);
        }
    };

    const borrarEvento = async(id) => {
        const confirmar = window.confirm(
                "Esta seguro de la eliminación"
            );

            if(!confirmar){
                return;
            }
        
            try {
                await eliminarEvento(id);
                cargarEventos();
                
            } catch (error) {
                console.error("Error al eliminar el evento",error)
            }
    }

    return (
        <div>
            <h1>Lista de eventos</h1>
            {eventos.length === 0 ? (
            <p>No hay eventos disponibles</p>
            ):(
                <div>
                    {eventos.map((evento) => (
                        <div key={evento.id}>

                            <h2>{evento.titulo}</h2>

                            <p>
                                <strong>ID:</strong> {evento.id}
                            </p>
                            {/* boton actualizar */}
                            <button onClick={
                                ()=> console.log("Actualizar eventos", evento.id)
                            }>
                                Actualizar
                            </button>

                            {/* Boton eliminar*/}
                            <button onClick ={() => borrarEvento(evento.id)} >
                                Eliminar
                            </button>

                        </div>
                    ))}
                </div>
            )}
        </div>
        );
}

export default ListaEventos;