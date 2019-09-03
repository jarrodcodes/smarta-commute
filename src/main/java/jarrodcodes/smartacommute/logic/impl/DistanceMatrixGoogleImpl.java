package jarrodcodes.smartacommute.logic.impl;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.LatLng;
import jarrodcodes.smartacommute.components.GCPKey;
import jarrodcodes.smartacommute.components.MartaStations;
import jarrodcodes.smartacommute.logic.DistanceMatrixInterface;
import jarrodcodes.smartacommute.models.DistanceDuration;
import jarrodcodes.smartacommute.models.StationDistanceResult;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DistanceMatrixGoogleImpl implements DistanceMatrixInterface {

    private static final String googlePlaceIdPrepend = "place_id:";

    @Override
    public final StationDistanceResult nearestMartaStationToLocation(String apiLocationId) throws IOException {

        DistanceMatrix stationMatrix = DistanceMatrixApi.getDistanceMatrix(GCPKey.getGcpContext(),
                new String[]{googlePlaceIdPrepend + apiLocationId}, MartaStations.getMartaStations().stream()
                        .map(station -> googlePlaceIdPrepend + station.getApiLocationId()).toArray(String[]::new)).awaitIgnoreError();

        return getStationDistanceResult(stationMatrix);
    }

    @Override
    public final StationDistanceResult nearestMartaStationToLocation(String latitude, String longitude) throws IOException {
        DistanceMatrix stationMatrix = DistanceMatrixApi.getDistanceMatrix(GCPKey.getGcpContext(),
                new String[]{new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude)).toString()}, MartaStations.getMartaStations().stream()
                        .map(x -> googlePlaceIdPrepend + x.getApiLocationId()).toArray(String[]::new)).awaitIgnoreError();

        return getStationDistanceResult(stationMatrix);
    }

    private static StationDistanceResult getStationDistanceResult(DistanceMatrix stationMatrix) throws IOException {
        List<DistanceMatrixElement> stationMatrixElementList = Arrays.asList(Arrays.asList(stationMatrix.rows).get(0).elements);

        int minimumDistanceEntry = 0;
        for (int i = 0; i < stationMatrixElementList.size(); i++) {
            long smallestFoundDistance = stationMatrixElementList.get(0).distance.inMeters;
            if (stationMatrixElementList.get(i).distance.inMeters < smallestFoundDistance) {
                smallestFoundDistance = stationMatrixElementList.get(i).distance.inMeters;
                minimumDistanceEntry = i;
            }
        }

        DistanceMatrixElement closestMartaStationMatrixElement = stationMatrixElementList.get(minimumDistanceEntry);

        return new StationDistanceResult(MartaStations.getMartaStations().get(minimumDistanceEntry),
                new DistanceDuration(closestMartaStationMatrixElement.distance.inMeters,
                        closestMartaStationMatrixElement.duration.inSeconds));
    }
}
