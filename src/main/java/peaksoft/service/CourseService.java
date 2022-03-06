package peaksoft.service;

import peaksoft.entity.Course;
import peaksoft.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface CourseService {

        Course saveCourse(Course course);

    List<Course> getAllCourse(long id);

    Course getByIdCourse(long id);

    void updateCourse(long id, Course course);

    void deleteCourse(long id);

//    void getByIdTeacherCourse(Teacher teacher, Course course);

}
