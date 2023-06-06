package microserviceapplication.exception;

import static microserviceapplication.exception.ErrorCodes.STUDENT_NOT_FOUND;

public class StudentNotFoundException extends GenericException {

    public StudentNotFoundException (){
        super(STUDENT_NOT_FOUND.getCode(),STUDENT_NOT_FOUND.getCode(),404);
    }
}
