package ro.hackaville.wsflights.imports.airports.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectReader {

    @JsonProperty("meta")
    private Map<String, String> meta;

    @JsonProperty("data")
    private List<ro.hackaville.wsflights.imports.airports.objects.ObjectDataReader> data;
}
