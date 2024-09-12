import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import './App.css';
import Inicio from './componentes/Inicio';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/inicio" element={<Inicio />} />
      </Routes>
    </Router>
  );
}

function Home() {
  return (
    <>
      <span id='Inicio'></span>
      
      <h1>Quiz</h1>
      <div className="card"></div>
      <p className="read-the-docs">
        <Link to="/inicio">INICIAR</Link>
      </p>
    </>
  );
}

export default App;
