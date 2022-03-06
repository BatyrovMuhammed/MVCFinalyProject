package peaksoft.service;

import peaksoft.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    Group saveGroup(Group group);

    List<Group> getAllGroup(Integer id);

    Group getByIdGroup(long id);

    void updateGroup(long id, Group group);

    void deleteGroup(long id);
}
