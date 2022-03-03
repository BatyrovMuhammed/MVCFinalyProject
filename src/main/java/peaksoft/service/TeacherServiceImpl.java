package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.TeacherDao;
import peaksoft.entity.Teacher;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
   private TeacherDao teacherDao;

     @Transactional
    @Override
    public Teacher saveTeacher(Teacher teacher) {
        teacherDao.saveTeacher(teacher);
        return teacher;
    }

    @Transactional
    @Override
    public List<Teacher> getAllTeacher(long id) {
        return teacherDao.getAllTeacher(id);
    }

    @Transactional
    @Override
    public Teacher getByIdTeacher(long id) {
        return teacherDao.getByIdTeacher(id);
    }

    @Transactional
    @Override
    public void updateTeacher(long id, Teacher teacher) {
      teacherDao.updateTeacher(id,teacher);
    }

    @Transactional
    @Override
    public void deleteTeacher(long id) {
        teacherDao.deleteTeacher(id);
    }
}
