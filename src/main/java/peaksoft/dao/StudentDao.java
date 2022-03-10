package peaksoft.dao;

import peaksoft.entity.Company;
import peaksoft.entity.Student;

import java.util.List;

public interface StudentDao {

    Student saveStudent(Student student);

    List<Student> getAllStudent(long id);

    Student getByIdStudent(long id);

    void updateStudent(Long id, Student student);

    void deleteStudent(long id);

}
