const API_URL = 'http://localhost:3030/usuarios'

export const obtenerUsuarios = async()=>{
    const respuesta = await fetch(API_URL)

    if (!respuesta.ok){
        throw new Error("Error al obtener usuarios")
    }
    return await respuesta.json()
}

export const obtenerUsuarioPorId = async(id)=>{
    const respuesta = await fetc(`${API_URL}/${id}`)

    if (!respuesta.ok){
        throw new Error("Error al obtener el usuario")
    }
    return await respuesta.json()
}

export const crearUsuario = async(usuario) => {
    const respuesta = await fetch(API_URL,{
        method: "POST",
        headers: {
            "Content-Type":"aplication/json"
        },
        body: JSON.stringify(usuario)
    })
    
    if (!respuesta.ok){
        throw new Error("Error al crear el usuario")
    }
    return await respuesta.json()
}

export const actualizarUsuario = async(id, usuario) => {
    const respuesta = await fetch(`${API_URL}/${id}`,{
        method: "PUT",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(usuario)
    })

    if (!respuesta.ok){
        throw new Error("Error al actualizar el usuario")
    }
    return await respuesta.json()
}

export const eliminarUsuario = async(id) => {
    const respuesta = await fetch(`${API_URL}/${id}`,{
        method: "DELETE",        
    })

    if(!respuesta.ok){
        throw new Error("Error al eliminar el usuario")
    }
    return true
}