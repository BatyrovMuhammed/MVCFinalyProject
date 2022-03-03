package peaksoft.service;

import peaksoft.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher saveTeacher(Teacher teacher);

    List<Teacher> getAllTeacher(long id);

    Teacher getByIdTeacher(long id);

    void updateTeacher(long id, Teacher teacher);

    void deleteTeacher(long id);
}
