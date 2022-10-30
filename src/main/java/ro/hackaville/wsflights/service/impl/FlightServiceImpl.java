package ro.hackaville.wsflights.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.hackaville.wsflights.exceptions.FlightNotFoundException;
import ro.hackaville.wsflights.exceptions.NoDataFoundException;
import ro.hackaville.wsflights.imports.flights.FlightsReader;
import ro.hackaville.wsflights.model.dto.FlightDto;
import ro.hackaville.wsflights.model.dto.body.FlightsRequest;
import ro.hackaville.wsflights.model.entity.Flight;
import ro.hackaville.wsflights.model.mapper.FlightsMapper;
import ro.hackaville.wsflights.repository.FlightRepository;
import ro.hackaville.wsflights.service.FlightService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightsMapper flightsMapper;
    private final FlightsReader flightsReader;

    public Flight handleFlight(final String id) {
        flightsReader.getFlightsAvailable();

        return flightRepository.getFlightById(id)
                .orElseThrow(() -> new FlightNotFoundException(id));

    }

    @Override
    public FlightDto getFlightById(final String id) {
        return flightsMapper.toDto(handleFlight(id));
    }

    @Override
    public List<FlightDto> getFlightsByFilter(FlightsRequest request) {
        final List<FlightDto> flightsList;

        final Pageable pageable = PageRequest.of(request.getPage(), 10);

        if ("ASC".equals(request.getFlightsFilter().getOrderType())) {
            flightsList = flightRepository.getFlightsByFiltersOrderbyAsc(request.getStartDate(),
                            request.getEndDate(), request.getLocation().getFlightLocation(), request.getLocation().getArriveLocation(),
                            request.getFlightsFilter().getFlightOperator(),
                            request.getFlightsFilter().getMinPrice(),
                            request.getFlightsFilter().getMaxPrice(),
                            request.getFlightsFilter().getFlightHourStart(),
                            request.getFlightsFilter().getFlightHourEnd(),
                            request.getFlightsFilter().getArriveHourStart(),
                            request.getFlightsFilter().getArriveHourEnd(),
                            request.getFlightsFilter().getOrderBy(),
                            pageable)
                    .stream()
                    .map(flightsMapper::toDto)
                    .toList();

        } else if ("DESC".equals(request.getFlightsFilter().getOrderType())) {
            flightsList = flightRepository.getFlightsByFiltersOrderbyDesc(request.getStartDate(),
                            request.getEndDate(), request.getLocation().getFlightLocation(), request.getLocation().getArriveLocation(),
                            request.getFlightsFilter().getFlightOperator(),
                            request.getFlightsFilter().getMinPrice(),
                            request.getFlightsFilter().getMaxPrice(),
                            request.getFlightsFilter().getFlightHourStart(),
                            request.getFlightsFilter().getFlightHourEnd(),
                            request.getFlightsFilter().getArriveHourStart(),
                            request.getFlightsFilter().getArriveHourEnd(),
                            request.getFlightsFilter().getOrderBy(),
                            pageable)
                    .stream()
                    .map(flightsMapper::toDto)
                    .toList();

        } else {
            flightsList = flightRepository.getFlightsByFilters(request.getStartDate(),
                            request.getEndDate(), request.getLocation().getFlightLocation(), request.getLocation().getArriveLocation(),
                            request.getFlightsFilter().getFlightOperator(),
                            request.getFlightsFilter().getMinPrice(),
                            request.getFlightsFilter().getMaxPrice(),
                            request.getFlightsFilter().getFlightHourStart(),
                            request.getFlightsFilter().getFlightHourEnd(),
                            request.getFlightsFilter().getArriveHourStart(),
                            request.getFlightsFilter().getArriveHourEnd(),
                            pageable)
                    .stream()
                    .map(flightsMapper::toDto)
                    .toList();
        }

        if (flightsList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return flightsList;
    }


}
