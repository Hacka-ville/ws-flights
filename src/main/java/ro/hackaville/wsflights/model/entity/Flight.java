package ro.hackaville.wsflights.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import ro.hackaville.wsflights.model.dao.FlightInformations;
import ro.hackaville.wsflights.model.dao.Location;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true)
    private String id;

    private Integer number;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "operator_id")
    private FlightsOperator operator;

    @Embedded
    private FlightInformations flightInformations;

    private BigDecimal price;

    @Embedded
    private Location location;

    private LocalTime delay;
}
