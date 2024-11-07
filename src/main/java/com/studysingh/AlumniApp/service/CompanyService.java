package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.College;
import com.studysingh.AlumniApp.model.Company;
import com.studysingh.AlumniApp.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(int companyId) {
        return companyRepository.findById(companyId);
    }

    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    public void updateCompany(Company company) {
        companyRepository.update(company);
    }

    public void deleteCompany(int companyId) {
        companyRepository.deleteById(companyId);
    }

    public int getCompanyNameByCompanyId(Company company) {
            return companyRepository.getCompanyNameByCompanyId(company);
    }
}
