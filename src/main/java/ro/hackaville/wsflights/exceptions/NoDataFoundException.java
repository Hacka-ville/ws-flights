package ro.hackaville.wsflights.exceptions;

import javax.persistence.EntityNotFoundException;

public class NoDataFoundException extends EntityNotFoundException {

    public NoDataFoundException() {
        super("No data has been found using filters!");
    }

}
