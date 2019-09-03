package jarrodcodes.smartacommute.controllers;

import jarrodcodes.smartacommute.components.MartaStations;
import jarrodcodes.smartacommute.models.Station;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/smarta", method = RequestMethod.GET)
public final class Stations {

    @RequestMapping(value = "/commute", method = RequestMethod.GET, produces = "application/json")
    private static List<Station> stationsList() throws IOException {
        return MartaStations.getMartaStations();
    }
}
