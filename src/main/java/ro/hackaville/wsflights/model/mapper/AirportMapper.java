package ro.hackaville.wsflights.model.mapper;

import org.mapstruct.Mapper;
import ro.hackaville.wsflights.model.dto.AirportDto;
import ro.hackaville.wsflights.model.entity.Airport;

import java.util.List;

@Mapper
public interface AirportMapper {

    AirportDto toDto(final Airport airport);

    Airport toEntity(final AirportDto airportDto);

    List<Airport> toEntityList(final List<AirportDto> airportDtoList);
}

