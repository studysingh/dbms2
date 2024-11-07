package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.College;
import com.studysingh.AlumniApp.model.Company;
import com.studysingh.AlumniApp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{companyId}")
    public Company getCompanyById(@PathVariable int companyId) {
        return companyService.getCompanyById(companyId);
    }

    @PostMapping
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @PutMapping("/{companyId}")
    public void updateCompany(@PathVariable int companyId, @RequestBody Company company) {
        company.setCompanyId(companyId);
        companyService.updateCompany(company);
    }

    @DeleteMapping("/{companyId}")
    public void deleteCompany(@PathVariable int companyId) {
        companyService.deleteCompany(companyId);
    }

    @PostMapping("/getId")
    public int getCompanyNameByCompanyId(@RequestBody Company company) {
        return companyService.getCompanyNameByCompanyId(company);
    }
}
