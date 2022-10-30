package ro.hackaville.wsflights.imports.airports;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ro.hackaville.wsflights.imports.airports.objects.ObjectDataReader;
import ro.hackaville.wsflights.imports.airports.objects.ObjectReader;
import ro.hackaville.wsflights.model.dao.City;
import ro.hackaville.wsflights.model.dto.AirportDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirportsReader {

    public List<AirportDto> getFlightsAvailable() {
        WebClient client = WebClient.create();

        final var responseSpec = client.get()
                .uri("https://api.duffel.com/air/airports?limit=200")
                .header("Duffel-Version", "beta")
                .header("Authorization", "Bearer duffel_test_SINz9CIvEUqswhNMoD1YvTf2dZvJwcyaqUCnkMqySAz")
                .retrieve()
                .bodyToMono(ObjectReader.class);

        final List<AirportDto> airportList = new ArrayList<>();
        final ObjectReader responseObject = responseSpec.block();
        final List<ObjectDataReader> objectDataReaderList = responseObject.getData();

        objectDataReaderList.forEach(object -> {
            City city = new City();
            city.setName(object.getCityName());
            city.setIataCode(object.getIataCode());
            city.setIataCountryCode(object.getIataCountryCode());

            AirportDto airport = new AirportDto();
            airport.setCity(city);
            airport.setLatitude(object.getLatitude());
            airport.setLongitude(object.getLongitude());

            airportList.add(airport);
        });

        return airportList;
    }
}
