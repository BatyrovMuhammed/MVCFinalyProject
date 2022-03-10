package peaksoft.dao;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class GroupDaoImpl implements GroupDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Group saveGroup(Group group) {
        entityManager.merge(group);
        return group;
    }

    @Override
    @Transactional
    public List<Group> getAllGroup(Long id) {
        //return entityManager.createQuery("select s from Group s where  s.id  =:id",Group.class).setParameter("id",id).getResultList();
         // return  entityManager.createQuery("select g from Group g",Group.class).getResultList();
        List<Group> groupList = entityManager.find(Course.class,id).getGroups();
        groupList.forEach(System.out::println);
        return groupList;
    }
    @Override
    @Transactional
    public Group getByIdGroup(Long id) {
        return entityManager.find(Group.class,id);
    }

    @Override
    @Transactional
    public void updateGroup(Long id, Group group) {
        Group groupCom = getByIdGroup(id);
        groupCom.setGroupName(group.getGroupName());
        groupCom.setDateOfStart(group.getDateOfStart());
        groupCom.setDateOfFinish(group.getDateOfFinish());
        entityManager.merge(groupCom);
    }
    @Override
    @Transactional
    public void deleteGroup(Long id) {
    // entityManager.remove(getByIdGroup(id));
        entityManager.createQuery("delete from Group where id =: id ").setParameter("id",id).executeUpdate();
    }
}
