package com.EducationalLoanPortal.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EducationalLoanPortal.demo.model.LoanApplicationModel;
import com.EducationalLoanPortal.demo.repository.LoanApplicationRepository;
@Service

public class AdminService

{
    @Autowired
    LoanApplicationRepository loanApp;
    public List<LoanApplicationModel> getAdmin()
      {
      return loanApp.findAll();
      }
      public LoanApplicationModel saveDeatils(LoanApplicationModel lm)
      {
           return loanApp.save(lm);
      }
}