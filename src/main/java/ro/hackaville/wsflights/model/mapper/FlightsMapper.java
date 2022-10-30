package ro.hackaville.wsflights.model.mapper;

import org.mapstruct.Mapper;
import ro.hackaville.wsflights.model.dto.FlightDto;
import ro.hackaville.wsflights.model.entity.Flight;

import java.util.List;

@Mapper
public interface FlightsMapper {

    FlightDto toDto(final Flight flight);

    Flight toEntity(final FlightDto flightDto);

    List<Flight> toEntityList(final List<FlightDto> flightDtoList);
}
