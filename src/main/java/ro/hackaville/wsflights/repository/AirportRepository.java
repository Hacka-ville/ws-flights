package ro.hackaville.wsflights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.hackaville.wsflights.model.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, String> {
}
