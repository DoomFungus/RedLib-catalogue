package edu.bht.ase.redlib.exception.ex;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import edu.bht.ase.redlib.exception.codes.ExceptionCodes;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@JsonIncludeProperties({"reasonCode", "reasonDescription"})
@Data
public class AbstractException extends RuntimeException {
    private final String reasonCode;
    private final String reasonDescription;

    public AbstractException(ExceptionCodes code) {
        reasonCode = code.getReasonCode();
        reasonDescription = code.getReasonDescription();
    }

    public AbstractException(String reasonCode, String reasonDescription) {
        this.reasonCode = reasonCode;
        this.reasonDescription = reasonDescription;
    }

    public AbstractException(ExceptionCodes code, Object... formatArgs) {
        reasonCode = code.getReasonCode();
        reasonDescription = String.format(code.getReasonDescription(), formatArgs);
    }

    public static AbstractException getGenericException(){
        return new AbstractException("GEN-001", "Exception occurred");
    }
}
