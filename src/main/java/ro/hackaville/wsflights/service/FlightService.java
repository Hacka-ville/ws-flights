package ro.hackaville.wsflights.service;

import ro.hackaville.wsflights.model.dto.FlightDto;
import ro.hackaville.wsflights.model.dto.body.FlightsRequest;

import java.util.List;

public interface FlightService {

    FlightDto getFlightById(final String id);

    List<FlightDto> getFlightsByFilter(final FlightsRequest request);
}
