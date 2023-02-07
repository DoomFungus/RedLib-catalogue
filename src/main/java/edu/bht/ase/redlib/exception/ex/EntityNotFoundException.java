package edu.bht.ase.redlib.exception.ex;

import edu.bht.ase.redlib.exception.codes.ExceptionCodes;

public class EntityNotFoundException extends AbstractException {

    public EntityNotFoundException(ExceptionCodes code) {
        super(code);
    }

    public EntityNotFoundException(ExceptionCodes code, Object... formatArgs) {
        super(code, formatArgs);
    }
}
