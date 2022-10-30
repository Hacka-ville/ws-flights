package ro.hackaville.wsflights.model.dao;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Location {

    @Builder.Default
    private String flightLocation = "";

    @Builder.Default
    private String arriveLocation = "";
}
