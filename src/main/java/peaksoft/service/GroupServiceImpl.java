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

    @Transactional
    @Override
    public Group saveGroup(Group group) {
        groupDao.saveGroup(group);
        return group;
    }

    @Transactional
    @Override
    public List<Group> getAllGroup() {
        return groupDao.getAllGroup();
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
