package ro.hackaville.wsflights.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import ro.hackaville.wsflights.model.entity.Flight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, String> {

    @Query("""
                SELECT F FROM Flight F
                WHERE F.id = :id
            """)
    Optional<Flight> getFlightById(@NonNull final String id);

    @Query("""
                SELECT F FROM Flight F
                WHERE ((:flightLocation = '' OR F.location.flightLocation = :flightLocation) AND
                (:arriveLocation = '' OR F.location.arriveLocation = :arriveLocation))
                AND (F.flightInformations.date >= :startDate AND F.flightInformations.date <= :endDate)
                AND F.price BETWEEN :minPrice AND :maxPrice
                AND (:flightOperator = '' OR F.operator.name = :flightOperator)
                AND (F.flightInformations.flightHour >= :flightHourStart AND F.flightInformations.flightHour <= :flightHourEnd)
                AND (F.flightInformations.arriveHour >= :arriveHourStart AND F.flightInformations.flightHour <= :arriveHourEnd)
                ORDER BY :orderBy ASC
            """)
    List<Flight> getFlightsByFiltersOrderbyAsc(@NonNull final LocalDate startDate,
                                               @NonNull final LocalDate endDate,
                                               final String flightLocation,
                                               final String arriveLocation,
                                               final String flightOperator,
                                               final BigDecimal minPrice,
                                               final BigDecimal maxPrice,
                                               final LocalTime flightHourStart,
                                               final LocalTime flightHourEnd,
                                               final LocalTime arriveHourStart,
                                               final LocalTime arriveHourEnd,
                                               final String orderBy,
                                               final Pageable pageable);

    @Query("""
                SELECT F FROM Flight F
                WHERE ((:flightLocation = '' OR F.location.flightLocation = :flightLocation) AND
                (:arriveLocation = '' OR F.location.arriveLocation = :arriveLocation))
                AND (F.flightInformations.date >= :startDate AND F.flightInformations.date <= :endDate)
                AND F.price BETWEEN :minPrice AND :maxPrice
                AND (:flightOperator = '' OR F.operator.name = :flightOperator)
                AND (F.flightInformations.flightHour >= :flightHourStart AND F.flightInformations.flightHour <= :flightHourEnd)
                AND (F.flightInformations.arriveHour >= :arriveHourStart AND F.flightInformations.flightHour <= :arriveHourEnd)
                ORDER BY :orderBy DESC
            """)
    List<Flight> getFlightsByFiltersOrderbyDesc(@NonNull final LocalDate startDate,
                                                @NonNull final LocalDate endDate,
                                                final String flightLocation,
                                                final String arriveLocation,
                                                final String flightOperator,
                                                final BigDecimal minPrice,
                                                final BigDecimal maxPrice,
                                                final LocalTime flightHourStart,
                                                final LocalTime flightHourEnd,
                                                final LocalTime arriveHourStart,
                                                final LocalTime arriveHourEnd,
                                                final String orderBy,
                                                final Pageable pageable);

    @Query("""
                SELECT F FROM Flight F
                WHERE ((:flightLocation = '' OR F.location.flightLocation = :flightLocation) AND
                (:arriveLocation = '' OR F.location.arriveLocation = :arriveLocation))
                AND (F.flightInformations.date >= :startDate AND F.flightInformations.date <= :endDate)
                AND F.price BETWEEN :minPrice AND :maxPrice
                AND (:flightOperator = '' OR F.operator.name = :flightOperator)
                AND (F.flightInformations.flightHour >= :flightHourStart AND F.flightInformations.flightHour <= :flightHourEnd)
                AND (F.flightInformations.arriveHour >= :arriveHourStart AND F.flightInformations.flightHour <= :arriveHourEnd)
            """)
    List<Flight> getFlightsByFilters(@NonNull final LocalDate startDate,
                                     @NonNull final LocalDate endDate,
                                     final String flightLocation,
                                     final String arriveLocation,
                                     final String flightOperator,
                                     final BigDecimal minPrice,
                                     final BigDecimal maxPrice,
                                     final LocalTime flightHourStart,
                                     final LocalTime flightHourEnd,
                                     final LocalTime arriveHourStart,
                                     final LocalTime arriveHourEnd,
                                     final Pageable pageable);

}
