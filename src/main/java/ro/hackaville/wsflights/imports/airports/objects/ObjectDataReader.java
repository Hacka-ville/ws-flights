package ro.hackaville.wsflights.imports.airports.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDataReader {

    @JsonProperty(value = "city_name")
    private String cityName;

    @JsonProperty(value = "iata_code")
    private String iataCode;

    private Double latitude;

    private Double longitude;

    @JsonProperty(value = "iata_country_code")
    private String iataCountryCode;
}
