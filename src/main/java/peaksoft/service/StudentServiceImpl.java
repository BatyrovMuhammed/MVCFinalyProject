package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.StudentDao;
import peaksoft.entity.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Transactional
    @Override
    public Student saveStudent(Student student) {
        studentDao.saveStudent(student);
        return student;
    }

    @Transactional
    @Override
    public List<Student> getAllStudent(long id) {
        return studentDao.getAllStudent(id);
    }

    @Transactional
    @Override
    public Student getByIdStudent(long id) {
        return studentDao.getByIdStudent(id);
    }

    @Transactional
    @Override
    public void updateStudent(long id, Student student) {
        studentDao.updateStudent(id, student);
    }

    @Transactional
    @Override
    public void deleteStudent(long id) {
        studentDao.deleteStudent(id);
    }
}
