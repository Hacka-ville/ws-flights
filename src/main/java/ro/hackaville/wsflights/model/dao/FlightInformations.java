package ro.hackaville.wsflights.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FlightInformations {

    private LocalDate date;

    private LocalTime flightHour;

    private LocalTime arriveHour;
}
