package microserviceapplication.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateStudentRequest {

    @NotBlank(message = "Name must not be nul!")
    String name;
    @NotBlank(message = "Surname must not be nul!")
    String surname;
    @NotBlank(message = "Group name must not be nul!")
    String groupName;
}
