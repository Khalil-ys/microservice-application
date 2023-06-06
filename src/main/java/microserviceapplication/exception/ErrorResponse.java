package microserviceapplication.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponse {

    Integer status;
    String code;
    String path;
    OffsetDateTime timestamp;
    List<String> detail;

}
