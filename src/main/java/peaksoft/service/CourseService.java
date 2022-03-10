package peaksoft.service;

import peaksoft.entity.Course;
import peaksoft.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface CourseService {

        Course saveCourse(Course course);

    List<Course> getAllCourse(Long id);

    Course getByIdCourse(Long id);

    void updateCourse(Long id, Course course);

    void deleteCourse(Long id);

//    void getByIdTeacherCourse(Teacher teacher, Course course);

}
