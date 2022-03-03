package peaksoft.dao;

import peaksoft.entity.Company;

import java.util.ConcurrentModificationException;
import java.util.List;

public interface CompanyDao {

    Company saveCompany(Company company);

    List<Company> getAllCompany();

    Company getByIdCompany(long id);

    void updateCompany(long id, Company company);

    void deleteCompany(long id);


}