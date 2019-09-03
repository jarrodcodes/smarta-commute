package jarrodcodes.smartacommute.models;

import lombok.Value;
import java.util.List;

@Value
public final class Station {
    final String name;
    final String apiLocationId;
    final List<String> lineColors;
    final boolean parkingAvailable;
}
