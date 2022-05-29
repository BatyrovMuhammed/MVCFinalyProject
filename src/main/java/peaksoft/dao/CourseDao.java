package peaksoft.dao;

import peaksoft.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseDao {

    Course saveCourse(Course course);

    List<Course> getAllCourse(Long id);

    Course getByIdCourse(Long id);

    void updateCourse(Long id, Course course);

    void deleteCourse(Long id);

}
