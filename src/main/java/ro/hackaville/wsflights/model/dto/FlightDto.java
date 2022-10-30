package ro.hackaville.wsflights.model.dto;

import lombok.*;
import ro.hackaville.wsflights.model.dao.FlightInformations;
import ro.hackaville.wsflights.model.dao.Location;
import ro.hackaville.wsflights.model.entity.FlightsOperator;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FlightDto {

    private String id;

    private Integer number;

    private FlightsOperator operator;

    private FlightInformations flightInformations;

    private BigDecimal price;

    private Location location;

    private LocalTime delay;
}
