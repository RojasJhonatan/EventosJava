import { useState } from "react";
import { crearEvento } from "../../service/eventoService";

function FormularioEvento(){
    const [titulo, setTitulo]= useState("");
    const [descripcion, setDescripcion]=useState("");
    const [fechaHora, setFechaHora]=useState("");
    const [lugar, setLugar]=useState("");
    const [capacidadMax, setCapacidadMax]=useState(0);
    const [precioBase, setPrecioBase]=useState(0);
    const [estado, setEstado]=useState("");

    const controlSubmit = async(e) => {
        e.preventDefault();
        const nuevoEvento = {
            titulo:titulo,
            descripcion:descripcion,
            fechaHora:fechaHora,
            lugar:lugar,
            capacidadMax:Number(capacidadMax),
            precioBase:Number(precioBase),
            estado:estado
        };
        try {
            const eventoGuardado = await crearEvento(nuevoEvento);
            console.log("Evento creado:",eventoGuardado);
            setTitulo("");
            setDescripcion("");
            setFechaHora("");
            setLugar("");
            setCapacidadMax(0);
            setPrecioBase(0);
            setEstado("");
        } catch (error) {
            console.error("Error al crear Evento",error)
        }
    };

    return (
        <div>
            <h1>Crear Evento</h1>
            <form onSubmit={controlSubmit}>
                <div>
                    <label>Título Evento</label>
                    <input type="text" value={titulo} onChange={(e) => setTitulo(e.target.value)}/>
                </div>
                <br/>
                <div>
                    <label>Descripción boton</label>
                    <textarea value={descripcion} onChange={(e) => setDescripcion(e.target.value)} >
                    </textarea>
                </div>
                <br/>
                <div>
                    <label>Fecha</label>
                    <input type="date" value={fechaHora} onChange={(e) => setFechaHora(e.target.value)}/>
                </div>
                <br/>
                <div>
                    <label>Lugar</label>
                    <input type="text" value={lugar} onChange={(e) => setLugar(e.target.value)}/>
                </div>
                <br/>
                <div>
                    <label>Capacidad Máxima</label>
                    <input type="number" value={capacidadMax} onChange={(e) => setCapacidadMax(e.target.value)}/>
                </div>
                <br/>
                <div>
                    <label>Precio Base</label>
                    <input type="number" value={precioBase} onChange={(e) => setPrecioBase(e.target.value)}/>
                </div>
                <br/>
                <div>
                    <label>Estado</label>
                    <select value={estado} onChange={(e) => setEstado(e.target.value)}>
                        <option value="">Seleccionar estado</option>
                        <option value="DISPONIBLE">Disponible</option>
                        <option value="AGOTADO">Agotado</option>
                        <option value="CERRADO">Cerrado</option>
                    </select>
                </div>
                <br />
                <div>
                    <button type="submit">
                    Guardar evento
                    </button>
                </div>
            </form>
        </div>
    );
}

export default FormularioEvento;