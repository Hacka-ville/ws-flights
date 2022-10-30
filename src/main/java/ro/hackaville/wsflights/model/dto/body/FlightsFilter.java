package ro.hackaville.wsflights.model.dto.body;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightsFilter {

    @Builder.Default
    private String orderBy = "";

    @Builder.Default
    private String flightOperator = "";

    @Builder.Default
    private BigDecimal minPrice = new BigDecimal(0);

    @Builder.Default
    private BigDecimal maxPrice = new BigDecimal(1000000);

    @Builder.Default
    private String orderType = "";

    @Builder.Default
    private LocalTime flightHourStart = LocalTime.MIN;

    @Builder.Default
    private LocalTime flightHourEnd = LocalTime.MAX;

    @Builder.Default
    private LocalTime arriveHourStart = LocalTime.MIN;

    @Builder.Default
    private LocalTime arriveHourEnd = LocalTime.MAX;
}
