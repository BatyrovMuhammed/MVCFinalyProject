package peaksoft.service;

import peaksoft.entity.Group;

import java.util.List;

public interface GroupService {

    Group saveGroup(Group group);

    List<Group> getAllGroup();

    Group getByIdGroup(long id);

    void updateGroup(long id, Group group);

    void deleteGroup(long id);
}
