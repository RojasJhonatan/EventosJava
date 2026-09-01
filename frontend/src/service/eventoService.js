const API_URL = 'http://localhost:3030/eventos'

//Función para obtener todos los eventos
export const obtenerEventos = async()=>{            
    const respuesta = await fetch(API_URL)

    if (!respuesta.ok){
        throw new Error("Error al obtener eventos")
    }
    return await respuesta.json()
} 

//Funcíon para obtener un evento por ID
export const obtenerEventosPorId = async(id)=>{         
    const respuesta = await fetch(`${API_URL}/${id}`)

    if (!respuesta.ok){
        throw new Error("Error al obtener el evento")
    }
    return await respuesta.json()
}
//Función para crear un nuevo evento 
export const crearEvento = async(evento)=>{
    const respuesta = await fetch(API_URL,{         //la función fetch cambia porque la solicitud para crear el evento no necesita un id 
        method: "POST",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(evento)
    })

    if (!respuesta.ok){
        throw new Error("Error al crear el evento")
    }

    return await respuesta.json()
}

//Función para actualizar un evento por ID
export const actualizarEvento = async(id, evento)=>{
    const respuesta = await fetch(`${API_URL}/${id}`,{
        method:"PUT",
        headers:{
            "Content-Type":"application.json"
        },
        body:JSON.stringify(evento)
    })
    
    if (!respuesta.ok){
        throw new Error("Error al actualizar el evento")
    }

    return await respuesta.json()
}

//Función para eliminar un evento por ID
export const eliminarEvento = async(id)=>{
    const respuesta = await fetch(`${API_URL}/${id}`,{
        method: "DELETE"
    })

    if (!respuesta.ok){
        throw new Error("Error al eliminar el evento")
    }

    return true
}
