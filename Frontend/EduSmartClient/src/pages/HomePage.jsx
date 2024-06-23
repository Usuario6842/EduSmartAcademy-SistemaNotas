
import { MainHome } from '../components/MainHome.jsx'
import { AboutPage } from './AboutPage.jsx'
import { LocationPage } from './LocationPage.jsx'

export const HomePage = () => {
    return (
        <>
            <MainHome />
            <AboutPage />
            <LocationPage />
        </>
    )
}