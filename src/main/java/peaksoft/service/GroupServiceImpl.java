package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.GroupDao;
import peaksoft.entity.Course;
import peaksoft.entity.Group;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;
    @Autowired
    private CourseService courseService;

    @Transactional
    @Override
    public Group saveGroup(Group group) {
//        Long courseId = group.getCourseId();
//        Course course = courseService.getByIdCourse(courseId);
//        group.setCourse(course);
        groupDao.saveGroup(group);
        return group;
    }

    @Transactional
    @Override
    public List<Group> getAllGroup(Integer id) {
        return groupDao.getAllGroup(id);
    }

    @Transactional
    @Override
    public Group getByIdGroup(long id) {
        return groupDao.getByIdGroup(id);
    }

    @Transactional
    @Override
    public void updateGroup(long id, Group group) {
     groupDao.updateGroup(id,group);
    }

    @Transactional
    @Override
    public void deleteGroup(long id) {
    groupDao.deleteGroup(id);
    }
}
