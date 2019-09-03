package jarrodcodes.smartacommute.models;

import lombok.Value;

@Value
public final class DistanceDuration {
    final long distanceInMeters;
    final long travelDuration;
    final String travelDurationWithTraffic = "";
}
