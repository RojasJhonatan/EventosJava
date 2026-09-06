import { BrowserRouter, Route, Routes } from "react-router-dom";

import FormularioEvento from "./components/eventos/FormularioEvento";
import ListaEventos from "./components/eventos/ListaEventos";
import ActualizarEvento from "./components/eventos/ActualizarEvento";

function App(){
  return(
      <BrowserRouter>
      <Routes>
        <Route 
          path="/"
          element={<ListaEventos/>}
        />
        <Route 
          path="/eventos/crear"
          element={<FormularioEvento />}
        />
        <Route 
          path="/eventos/editar/:id"
          element={<FormularioEvento />}
        />
        </Routes>
      </BrowserRouter>

  )
}

export default App;