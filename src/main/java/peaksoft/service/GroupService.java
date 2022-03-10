package peaksoft.service;

import peaksoft.entity.Group;

import java.util.List;

public interface GroupService {

    Group saveGroup(Group group);

    List<Group> getAllGroup(Long id);

    Group getByIdGroup(Long id);

    void updateGroup(Long id, Group group);

    void deleteGroup(Long id);

   // Group groupRequestGroup(GroupDto groupDto);
}
