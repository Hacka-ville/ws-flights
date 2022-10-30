package ro.hackaville.wsflights.imports;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ro.hackaville.wsflights.imports.airports.AirportsReader;
import ro.hackaville.wsflights.imports.flights.FlightsReader;
import ro.hackaville.wsflights.model.mapper.AirportMapper;
import ro.hackaville.wsflights.model.mapper.FlightsMapper;
import ro.hackaville.wsflights.repository.AirportRepository;
import ro.hackaville.wsflights.repository.FlightRepository;

@Component
@EnableScheduling
@Async
@RequiredArgsConstructor
public class ImportDataJob {

    private final AirportsReader airportsReader;
    private final AirportMapper airportMapper;
    private final AirportRepository airportRepository;
    private final FlightsReader flightsReader;
    private final FlightsMapper flightsMapper;
    private final FlightRepository flightRepository;

    @Scheduled(cron = "0 * * * * *", zone = "Europe/Bucharest")
    public void saveFlights() {
        var airportDtos = airportsReader.getFlightsAvailable();
        airportRepository.deleteAll();
        airportRepository.saveAll(airportMapper.toEntityList(airportDtos));

        var flights = flightsReader.getFlightsAvailable();
        flightRepository.deleteAll();
        flightRepository.saveAll(flightsMapper.toEntityList(flights));
    }
}
