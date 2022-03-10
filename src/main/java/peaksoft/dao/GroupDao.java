package peaksoft.dao;

import peaksoft.entity.Course;
import peaksoft.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupDao {

    Group saveGroup(Group group);

    List<Group> getAllGroup(Long id);

    Group getByIdGroup(Long id);

    void updateGroup(Long id, Group group);

    void deleteGroup(Long id);
}
