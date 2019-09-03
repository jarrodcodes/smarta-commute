package jarrodcodes.smartacommute.models;

import lombok.Value;

@Value
public final class UserLocation {
    final String latitude;
    final String longitude;
    final boolean isGeoLocation = false;
}
