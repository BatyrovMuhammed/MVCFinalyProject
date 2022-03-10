package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.GroupDao;
import peaksoft.entity.Group;

import java.util.List;

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
    public List<Group> getAllGroup(Long id) {
        return groupDao.getAllGroup(id);
    }

    @Transactional
    @Override
    public Group getByIdGroup(Long id) {
        return groupDao.getByIdGroup(id);
    }

    @Transactional
    @Override
    public void updateGroup(Long id, Group group) {
     groupDao.updateGroup(id,group);
    }

    @Transactional
    @Override
    public void deleteGroup(Long id) {
    groupDao.deleteGroup(id);
    }

//    @Override
//    public Group groupRequestGroup(GroupDto groupDto) {
//        Group group = new Group();
//        group.setGroupName(groupDto.getGroupName());
//        group.setDateOfStart(groupDto.getDateStart());
//        group.setDateOfFinish(groupDto.getDateFinish());
//        group.setCourseId(groupDto.getCourseId());
//        return group;
//    }
}
