package jarrodcodes.smartacommute.components;

import com.google.maps.GeoApiContext;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public final class GCPKey {

    @Getter
    private static GeoApiContext gcpContext = new GeoApiContext.Builder()
            .apiKey("AIzaSyCUeMp6N7OR19nhzJR2rY4BhPjatg22n1I")
            .build();
}
