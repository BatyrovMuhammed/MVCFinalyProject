package peaksoft.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.CompanyDao;
import peaksoft.entity.Company;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao dao;

    @Transactional
    @Override
    public Company saveCompany(Company company) {
        dao.saveCompany(company);
        return company;
    }

    @Transactional
    @Override
    public List<Company> getAllCompany() {
        return dao.getAllCompany();
    }

    @Transactional
    @Override
    public Company getByIdCompany(long id) {
        return dao.getByIdCompany(id);
    }

    @Transactional
    @Override
    public void updateCompany(long id,Company company) {
         dao.updateCompany(id,company);
    }

    @Transactional
    @Override
    public void deleteCompany(long id) {
        dao.deleteCompany(id);
    }
}
