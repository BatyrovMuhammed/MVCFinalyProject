package peaksoft.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Group saveGroup(Group group) {
        entityManager.persist(group);
        return group;
    }

    @Override
    @Transactional
    public List<Group> getAllGroup() {
        return entityManager.createQuery("select s from Group s",Group.class).getResultList();
    }

    @Override
    @Transactional
    public Group getByIdGroup(long id) {
        return entityManager.find(Group.class,id);
    }

    @Override
    @Transactional
    public void updateGroup(long id, Group group) {
        Group groupCom = getByIdGroup(id);
        groupCom.setGroupName(group.getGroupName());
        groupCom.setDateOfStart(group.getDateOfStart());
        groupCom.setDateOfFinish(group.getDateOfFinish());
        entityManager.merge(groupCom);
    }

    @Override
    @Transactional
    public void deleteGroup(long id) {
     entityManager.remove(getByIdGroup(id));
    }
}
