package peaksoft.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Student;
import peaksoft.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public Teacher saveTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    @Override
    @Transactional
    public List<Teacher> getAllTeacher(long id) {
        return entityManager.createQuery("select s from Teacher s where s.course.id=:id",Teacher.class).setParameter("id",id).getResultList();
    }

    @Override
    @Transactional
    public Teacher getByIdTeacher(long id) {
        return entityManager.find(Teacher.class,id);
    }

    @Override
    @Transactional
    public void updateTeacher(long id, Teacher teacher) {
        Teacher teacherCom = getByIdTeacher(id);
        teacherCom.setFirstName(teacher.getFirstName());
        teacherCom.setEmail(teacher.getEmail());
        teacherCom.setLastName(teacher.getLastName());
        teacherCom.setCourseId(teacher.getCourseId());
        entityManager.merge(teacherCom);
    }

    @Override
    @Transactional
    public void deleteTeacher(long id) {
    entityManager.remove(getByIdTeacher(id));
    }
}
