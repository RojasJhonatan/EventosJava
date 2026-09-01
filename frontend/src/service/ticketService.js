const API_URL = 'http://localhost:3030/tickets'

export const obtenerTickets = async() => {
    const respuesta = await fetch(API_URL)

    if (!respuesta.ok){
        throw new Error("Error al obtener tickets")
    }
    return await respuesta.json()
}

export const obtenerTicketsPorId = async(id) => {
    const respuesta = await fetch(`${API_URL}/${id}`)

    if (!respuesta.ok){
        throw new Error("Error al obtener el ticket")
    }
    return await respuesta.json()
}

export const crearUsuario = async(ticket) => {
    const respuesta = await fetch(API_URL,{
        method: "POST",
        headers: {
            "Content-Type":"application/json"
        },
        body: JSON.stringify(ticket)
    })

    if(!respuesta.ok){
        throw new Error("Error al crear el ticket")
    }
    return await respuesta.json()
}

export const eliminarTicket = async(id) => {
    const respuesta = await fetch(`${API_URL}/${id}`,{
        method: "DELETE",
    })

    if(!respuesta.ok){
        throw new Error("Error al eliminar el ticket")
    }
    return await respuesta.json()
}