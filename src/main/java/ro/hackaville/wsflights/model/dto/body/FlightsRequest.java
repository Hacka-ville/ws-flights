package ro.hackaville.wsflights.model.dto.body;

import lombok.*;
import ro.hackaville.wsflights.model.dao.Location;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightsRequest {

    private Location location;

    @Builder.Default
    private FlightsFilter flightsFilter = FlightsFilter.builder().build();

    private LocalDate startDate;

    private LocalDate endDate;

    @Builder.Default
    private Integer page = 0;
}
