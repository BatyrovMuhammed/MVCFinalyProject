package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.CourseDao;
import peaksoft.entity.Course;
import peaksoft.entity.Teacher;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Transactional
    @Override
    public Course saveCourse(Course course) {
        courseDao.saveCourse(course);
        return course;
    }

    @Transactional
    @Override
    public List<Course> getAllCourse(long id) {
        return courseDao.getAllCourse(id);
    }

    @Transactional
    @Override
    public Course getByIdCourse(long id) {
        return courseDao.getByIdCourse(id);
    }

    @Transactional
    @Override
    public void updateCourse(long id, Course course) {
      courseDao.updateCourse(id,course);
    }

    @Transactional
    @Override
    public void deleteCourse(long id) {
     courseDao.deleteCourse(id);
    }

//    @Override
//    public void getByIdTeacherCourse(Teacher teacher, Course course) {
//        courseDao.getByIdTeacherCourse(teacher,course);
//    }
}
