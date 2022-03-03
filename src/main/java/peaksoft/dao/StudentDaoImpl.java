package peaksoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Company;
import peaksoft.entity.Student;
import peaksoft.entity.StudyFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public List<Student> getAllStudent(long id) {
        return entityManager.createQuery("select s from Student s where s.group.id=:id", Student.class).setParameter("id",id).getResultList();

    }

    @Override
    @Transactional
    public Student getByIdStudent(long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    @Transactional
    public void updateStudent(long id, Student student) {
        Student studentCom = getByIdStudent(id);
        studentCom.setFirstName(student.getFirstName());
        studentCom.setEmail(student.getEmail());
        studentCom.setLastName(student.getLastName());
        studentCom.setStudyFormat(student.getStudyFormat());
        studentCom.setGroupId(student.getGroupId());
        entityManager.merge(studentCom);
    }

    @Override
    @Transactional
    public void deleteStudent(long id) {
   entityManager.remove(getByIdStudent(id));
    }
}
