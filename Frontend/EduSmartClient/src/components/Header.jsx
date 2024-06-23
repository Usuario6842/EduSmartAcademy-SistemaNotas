import {LogoSVG, TitleSVG} from '../icons/icons.jsx'
import {Link} from 'react-router-dom'
import '../css/header.css'


export const Header = () => {
    return (
        <header className="header">
            <nav className="header-nav">
                <h1 className="header-h1">
                    < LogoSVG className={'header-logo'} ariaLabel={'Logo EduSmart Academy'}/>
                    < TitleSVG className={'header-title'} ariaLabel={'EduSmart Academy'} />
                </h1>
                <ul className="header-ul">
                    <li className="header-li"><Link href="/" className='header-item'>Inicio</Link></li>
                    <li className="header-li"><a href="#nosotros" className='header-item'>Nosotros</a></li>
                    <li className="header-li"><a href="#ubicacion" className='header-item'>Ubicacion</a></li>
                    <li className="header-li"><a href="#redes" className='header-item'>Redes Sociales</a></li>
                    <li className="header-li"><Link to="/" className='header-item'>Alumnos</Link></li>
                    <li className="header-li"><Link to="/" className='header-item'>Docentes</Link></li>
                </ul>
                <button className="header-button">Ingresar</button>
            </nav>
        </header>
    )
}