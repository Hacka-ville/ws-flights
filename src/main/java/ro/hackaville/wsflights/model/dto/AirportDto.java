package ro.hackaville.wsflights.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.hackaville.wsflights.model.dao.City;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirportDto {

    private String id;

    private City city;

    private Double latitude;

    private Double longitude;
}
