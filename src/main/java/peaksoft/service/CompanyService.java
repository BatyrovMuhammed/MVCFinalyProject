package peaksoft.service;

import peaksoft.entity.Company;

import java.util.List;

public interface CompanyService {

    Company saveCompany(Company company);

    List<Company> getAllCompany();

    Company getByIdCompany(long id);

    void updateCompany(long id, Company company);

    void deleteCompany(long id);


}
