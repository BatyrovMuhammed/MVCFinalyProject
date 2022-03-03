package peaksoft.service;

import peaksoft.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudent(long id);

    Student getByIdStudent(long id);

    void updateStudent(long id, Student student);

    void deleteStudent(long id);
}
