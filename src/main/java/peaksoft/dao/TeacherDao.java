package peaksoft.dao;

import peaksoft.entity.Company;
import peaksoft.entity.Teacher;

import java.util.List;

public interface TeacherDao {

    Teacher saveTeacher(Teacher teacher);

    List<Teacher> getAllTeacher(long id);

    Teacher getByIdTeacher(long id);

    void updateTeacher(long id, Teacher teacher);

    void deleteTeacher(long id);
}
