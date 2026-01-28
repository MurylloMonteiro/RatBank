package git.MurylloMonteiro.Ratbank.Exeptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handlerDataIntegrity(){
        return new ResponseEntity<>("Dados invalidos", HttpStatus.CONFLICT);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerRuntimeException(RuntimeException ex){

        return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
