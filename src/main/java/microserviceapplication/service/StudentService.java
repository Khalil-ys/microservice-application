package microserviceapplication.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import microserviceapplication.dto.CreateStudentRequest;
import microserviceapplication.dto.StudentResponse;
import microserviceapplication.dto.UpdateStudentRequest;
import microserviceapplication.exception.StudentNotFoundException;
import microserviceapplication.mapper.StudentMapper;
import microserviceapplication.model.Student;
import microserviceapplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class StudentService {

    StudentRepository repository;
    StudentMapper mapper;

    public void createStudent(CreateStudentRequest request) {
        repository.save(mapper.mapRequestToStudent(request));
    }

    public List<StudentResponse> getAll() {
        return repository.findAll().stream().map(mapper::mapEntityToResponse).collect(Collectors.toList());
    }

    public StudentResponse getStudent(Long id) {
        var student = repository.findById(id).orElseThrow(this::ex);
        return mapper.mapEntityToResponse(student);
    }

    public void deleteStudent(Long id) {
        var student = repository.findById(id).orElseThrow(this::ex);
        repository.deleteById(student.getId());
    }

    public StudentNotFoundException ex() {
        throw new StudentNotFoundException();
    }

    public void updateStudent(Long id, UpdateStudentRequest request) {
        var student = repository.findById(id).orElseThrow(this::ex);
        mapper.mapUpdateRequestToEntity(student, request);
        repository.save(student);
    }
}
