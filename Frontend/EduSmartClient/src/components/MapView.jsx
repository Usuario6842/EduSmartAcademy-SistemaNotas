import React from "react"
import { Map, Marker } from "pigeon-maps"

export const MyMap = () => {
    const initialCenter = [-16.497, -68.193333]; 
    const markerPosition = [-16.48931957,-68.19286677];
    const markerTooltip = "EduSmart Academy"; 

    return (
        <Map height={450} defaultCenter={initialCenter} defaultZoom={13}>
            <Marker width={50} anchor={markerPosition} tooltip={markerTooltip} />
        </Map>
    )
}