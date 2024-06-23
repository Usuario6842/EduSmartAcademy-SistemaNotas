import '../css/about.css'
import { CheckSVG } from '../icons/icons'

export const AboutPage = () => {
    return(
            <section id="nosotros" className="about">
                <h3 className="about-h3">Acerca de nosotros</h3>
                <ul className="about-ul">
                    <li className="about-li">
                        <h4 className="about-h4">¿Quienes somos?</h4>
                        <p className="about-p">En EduSmart Academy, creemos en la educación como la llave que abre las puertas hacia un futuro brillante.</p>
                        <p className="about-p">Nos apasiona brindar a nuestros estudiantes las herramientas y el apoyo que necesitan para alcanzar sus sueños.</p>
                    </li>
                    <li className="about-li">
                        <h4 className="about-h4">Nuestros valores</h4>
                        <ul className="valor-ul">
                            <li className="valor-li"><CheckSVG className={'valor-svg'} /> <span>Respeto</span> </li>
                            <li className="valor-li"><CheckSVG className={'valor-svg'} /> <span>Excelencia</span> </li>
                            <li className="valor-li"><CheckSVG className={'valor-svg'} /> <span>Compromiso</span> </li>
                            <li className="valor-li"><CheckSVG className={'valor-svg'} /> <span>Responsabilidad</span> </li>
                        </ul>
                    </li>
                </ul>
                
            </section>
        
    )
}