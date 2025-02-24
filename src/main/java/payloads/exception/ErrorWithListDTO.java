package payloads.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ErrorWithListDTO extends ErrorDTO {
    List<String> errorList;

    public ErrorWithListDTO(String message, Date date, List<String> errorList){
        super(message,date);
        this.errorList = errorList;

    }
}
