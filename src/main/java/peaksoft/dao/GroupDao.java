package peaksoft.dao;

import peaksoft.entity.Course;
import peaksoft.entity.Group;

import java.util.List;

public interface GroupDao {

    Group saveGroup(Group group);

    List<Group> getAllGroup();

    Group getByIdGroup(long id);

    void updateGroup(long id, Group group);

    void deleteGroup(long id);
}
