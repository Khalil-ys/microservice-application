package microserviceapplication.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import microserviceapplication.dto.CreateStudentRequest;
import microserviceapplication.dto.StudentResponse;
import microserviceapplication.dto.UpdateStudentRequest;
import microserviceapplication.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/api")
public class StudentController {

    StudentService service;

    @PostMapping
    public void createStudent(@Valid @RequestBody CreateStudentRequest request){
        service.createStudent(request);
    }

    @CircuitBreaker(name = "gatAllStudents")
    @GetMapping
    public List<StudentResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudent(@PathVariable Long id){
        return service.getStudent(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id,@RequestBody UpdateStudentRequest request){
        service.updateStudent(id,request);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
    }

}
