package peaksoft.dao;

import peaksoft.entity.Company;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class CompanyDaoImpl implements CompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Company saveCompany(Company company) {
        entityManager.persist(company);
        return company;
    }

    @Override
    @Transactional
    public List<Company> getAllCompany() {
        return entityManager.createQuery("select s from Company s", Company.class).getResultList();

    }

    @Override
    @Transactional
    public Company getByIdCompany(long id) {
        return entityManager.find(Company.class,id);
    }

    @Override
    @Transactional
    public void updateCompany(long id , Company company) {
        Company companyCom = getByIdCompany(id);
        companyCom.setCompanyName(company.getCompanyName());
        companyCom.setLocatedCountry(company.getLocatedCountry());
         entityManager.merge(companyCom);
    }

    @Override
    @Transactional
    public void deleteCompany(long id) {
      entityManager.remove(getByIdCompany(id));
    }
}
