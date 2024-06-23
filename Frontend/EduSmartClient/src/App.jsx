
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './css/app.css'
import { HomePage } from "./pages/HomePage.jsx"
import { Header } from "./components/Header.jsx"
import { FooterHome } from './components/FooterHome.jsx';

function App() {

  return (
    <>
      <div className="wrapper">
        <Router>
          <Header />
          <Routes>
            <Route path="/" element={<HomePage />} />
         
          </Routes>
          <FooterHome />
        </Router>
      </div>
    </>
  )
}

export default App
