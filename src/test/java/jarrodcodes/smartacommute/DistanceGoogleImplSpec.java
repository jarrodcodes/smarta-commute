package jarrodcodes.smartacommute;

import jarrodcodes.smartacommute.logic.DistanceMatrixInterface;
import jarrodcodes.smartacommute.logic.impl.DistanceMatrixGoogleImpl;
import jarrodcodes.smartacommute.models.StationDistanceResult;
import org.junit.Test;

import java.io.IOException;

public class DistanceGoogleImplSpec {

    @Test
    public void test() throws IOException {
        DistanceMatrixInterface distanceMatrixGoogle = new DistanceMatrixGoogleImpl();
        StationDistanceResult test = distanceMatrixGoogle.nearestMartaStationToLocation("ChIJOwg_06VPwokRYv534QaPC8g");
    }
    @Test
    public void test2() throws IOException {
        DistanceMatrixInterface distanceMatrixGoogle = new DistanceMatrixGoogleImpl();
        StationDistanceResult test = distanceMatrixGoogle.nearestMartaStationToLocation("33.748997", "-84.387985");
    }
}
