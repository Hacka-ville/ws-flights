package ro.hackaville.wsflights.imports.flights;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ro.hackaville.wsflights.model.dao.FlightInformations;
import ro.hackaville.wsflights.model.dao.Location;
import ro.hackaville.wsflights.model.dto.FlightDto;
import ro.hackaville.wsflights.model.entity.FlightsOperator;
import ro.hackaville.wsflights.repository.AirportRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RequiredArgsConstructor
@Component
public class FlightsReader {

    private final AirportRepository airportRepository;

    @SneakyThrows
    public List<FlightDto> getFlightsAvailable() {
        Random random = new Random();

        List<FlightDto> flightDtoList = new ArrayList<>();

        airportRepository.findAll().forEach(airports -> {
            FlightInformations flightInformations = new FlightInformations();
            flightInformations.setFlightHour(LocalTime.of(random.nextInt(1), random.nextInt(24)));
            flightInformations.setArriveHour(flightInformations.getFlightHour().plusHours(2));
            flightInformations.setDate(LocalDate.of(2022, random.nextInt(11, 12), random.nextInt(1, 30)));

            FlightsOperator flightsOperator = new FlightsOperator();
            flightsOperator.setName(random.nextInt() % 2 == 0 ? "WIZZ" : "RY");
            flightsOperator.setFullName(random.nextInt() % 2 == 0 ? "Wizz Air" : "Ryanair");

            Location location = new Location();
            location.setFlightLocation(airports.getCity().getName());
            var otherlocations = airportRepository.findAll().stream()
                    .filter(a -> !Objects.equals(a.getId(), airports.getId()))
                    .toList();
            location.setArriveLocation(otherlocations.get(random.nextInt(1, otherlocations.size() - 1)).getCity().getName());

            FlightDto flight = new FlightDto();
            flight.setDelay(LocalTime.of(random.nextInt() % 2 == 0 ? 0 : 1, 0));
            flight.setNumber(random.nextInt(1000, 2400));
            flight.setOperator(flightsOperator);
            flight.setFlightInformations(flightInformations);
            flight.setLocation(location);
            flight.setPrice(BigDecimal.valueOf(random.nextDouble(100, 1000)));

            flightDtoList.add(flight);
        });

        return flightDtoList;
    }
}
