package jarrodcodes.smartacommute.models;

import lombok.Value;

@Value
public final class StationDistanceResult {
    final Station result;
    final DistanceDuration distanceDuration;
}
