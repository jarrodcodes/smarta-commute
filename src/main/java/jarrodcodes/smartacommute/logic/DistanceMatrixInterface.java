package jarrodcodes.smartacommute.logic;

import jarrodcodes.smartacommute.models.StationDistanceResult;

import java.io.IOException;

public interface DistanceMatrixInterface {

    StationDistanceResult nearestMartaStationToLocation(String apiLocationId) throws IOException;

    StationDistanceResult nearestMartaStationToLocation(String latitude, String longitude) throws IOException;

}
