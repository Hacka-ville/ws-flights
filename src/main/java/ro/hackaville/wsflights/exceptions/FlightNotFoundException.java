package ro.hackaville.wsflights.exceptions;

import javax.persistence.EntityNotFoundException;

public class FlightNotFoundException extends EntityNotFoundException {

    public FlightNotFoundException(final String id) {
        super(String.format("Flight with ID %s has not been found!", id));
    }
}
