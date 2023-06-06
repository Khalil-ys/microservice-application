package microserviceapplication.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class GenericException extends RuntimeException{

    String code;
    String message;
    int status;

    public GenericException(String code,String message,int status){
        super(message);
        this.status=status;
        this.code=code;
        this.message=message;
    }

//    public GenericException (String errorBody, HttpStatus statusCode){
//        super(errorBody);
//        this.status=statusCode.value();
//        this.code=statusCode.name();
//        this.message=errorBody;
//    }

    @Override
    public String toString(){
        return String.format("%s{status=%d,code='%s',message='%s'}",
                this.getClass().getSimpleName(),status,code,message);
    }
}
