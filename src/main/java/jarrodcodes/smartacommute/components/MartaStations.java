package jarrodcodes.smartacommute.components;

import jarrodcodes.smartacommute.models.Station;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class MartaStations {

    private static final String stationListFileLocation = "/static/stationslist.txt";

    private static List<Station> martaStations() throws IOException {
        List<Station> allStations = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(MartaStations.class.getResource(stationListFileLocation).getFile()));
        br.lines().forEach(line -> {
            String[] station = line.split(",");
            List<String> stationColors = Arrays.stream(station[2].trim().split("-")).collect(Collectors.toList());
            allStations.add(new Station(station[0].trim(), station[1].trim(), stationColors, Boolean.parseBoolean(station[3])));
        });
        br.close();
        allStations.sort(Comparator.comparing(Station::getName));
        return allStations;
    }

    public static List<Station> getMartaStations() throws IOException {
            return martaStations();
    }
}
