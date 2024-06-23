import { ImageHomeSVG, CircleHomeSVG, CurveSVG, Circle2HomeSVG } from "../icons/icons.jsx"
import '../css/mainHome.css'

export const MainHome = () => {
    return (
        <>
            <main className="main">
                <section className="main-section">
                    <h2 className="main-h2">Fomenta una cultura de <strong>aprendizaje continuo</strong></h2>
                    <p className="main-p">Nuestra institución educativa está comprometida con el aprendizaje continuo y la mejora la participacion activa en el rendimiento académico de todos los estudiantes.
                    </p>
                    <button className="main-button">Ingresar</button>
                </section>
                <ImageHomeSVG className={'main-svg'} />
            </main>
            <CircleHomeSVG className={'circle1'} />
            <Circle2HomeSVG className={'circle2'} />
            <CurveSVG className={'curve1'} />
            <CurveSVG className={'curve2'} />
        </>
    )

}