package peaksoft.dao;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseDao {

    Course saveCourse(Course course);

    List<Course> getAllCourse(long id);

    Course getByIdCourse(long id);

    void updateCourse(long id, Course course);

    void deleteCourse(long id);

//    void getByIdTeacherCourse(Teacher teacher, Course course);
}
