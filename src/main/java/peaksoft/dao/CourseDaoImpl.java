package peaksoft.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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
    public List<Course> getAllCourse(Long id) {
        return entityManager.createQuery("select s from Course s where s.company.id=:id", Course.class).setParameter("id",id).getResultList();
    }

    @Override
    @Transactional
    public Course getByIdCourse(Long id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void updateCourse( Long id,Course course) {
        Course courseCom = getByIdCourse(id);
        courseCom.setCourseName(course.getCourseName());
        courseCom.setDuration(course.getDuration());
        courseCom.setCompanyId(course.getCompanyId());
        entityManager.merge(courseCom);
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
      entityManager.remove(getByIdCourse(id));
    }

}
