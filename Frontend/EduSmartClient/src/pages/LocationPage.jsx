
import '../css/location.css'
import {MyMap} from '../components/MapView.jsx'


export const LocationPage = () => {
    return (
        <>
            <section id='ubicacion' className="location">
                <h3 className="location-h3">Cómo puedes encontrarnos</h3>
                <div className="location-div">
                    <ul className="location-ul">
                        <li className="location-li">
                            <h4 className="location-h4">Dirección</h4>
                            <p className="location-p">Estamos ubicados en la Calle Principal #123, Ciudad, País.</p>
                        </li>
                        <li className="location-li">
                            <h4 className="location-h4">Horario de atención</h4>
                            <p className="location-p">Ven a visitarnos durante nuestro horario de atención:</p>
                            <ul className="location-list">
                                <li className="list-li">Lunes a Viernes: 9:00 AM - 6:00 PM</li>
                                <li className="list-li">Sábados: 10:00 AM - 2:00 PM</li>
                            </ul>
                        </li>
                    </ul>
                    <div className="location-map">
                        <MyMap />
                    </div>
                </div>
            </section>
        </>
    )
}