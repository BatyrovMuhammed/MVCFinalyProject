package peaksoft.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public Course saveCourse(Course course) {
        entityManager.merge(course);
        return course;
    }

    @Override
    @Transactional
    public List<Course> getAllCourse(long id) {
        return entityManager.createQuery("select s from Course s where s.company.id=:id", Course.class).setParameter("id",id).getResultList();
    }

    @Override
    @Transactional
    public Course getByIdCourse(long id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void updateCourse(long id, Course course) {
        Course courseCom = getByIdCourse(id);
        courseCom.setCourseName(course.getCourseName());
        courseCom.setDuration(course.getDuration());
        courseCom.setCompanyId(course.getCompanyId());
        entityManager.merge(courseCom);
    }

    @Override
    @Transactional
    public void deleteCourse(long id) {
      entityManager.remove(getByIdCourse(id));
    }

//    @Override
//    public void getByIdTeacherCourse(Teacher teacher,Course course) {
//        entityManager.getTransaction().begin();
//        Teacher teacher1 = entityManager.find(Teacher.class,teacher.getId());
//        Course course1 = entityManager.find(Course.class,course.getId());
//        teacher1.setId(3);
//        course1.setTeacher(teacher1);
//        entityManager.getTransaction().commit();
//
//    }
}
