package com.EducationalLoanPortal.demo.service;
import java.util.List;
//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EducationalLoanPortal.demo.model.LoanApplicationModel;
import com.EducationalLoanPortal.demo.model.UserModel;
import com.EducationalLoanPortal.demo.repository.LoanApplicationRepository;
import com.EducationalLoanPortal.demo.repository.UserRepository;
@Service

public class UserService
{
	@Autowired

	UserRepository userRep;

	@Autowired

	LoanApplicationRepository laRep;

	public UserModel saveUser(UserModel l)

	{

		return userRep.save(l);

	}

	public String valideteUser(String email,String password)

	{

		String result=" ";

		UserModel l=userRep.findByEmail(email);

		if(l==null)

		{

			result="User not found";

		}

		else

		{

			if(l.getPassword().equals(password))

			{

				result="Login success";

			}

			else

			{

				result="Login failed";

			}

		}

		return result;

	}

	public List<UserModel> get()

	{

		List<UserModel> um=userRep.findAll();

		return um;

	}

	public LoanApplicationModel getById(int id)

	{

		LoanApplicationModel gbi=laRep.findById(id).get();

		return gbi;

		

	}

	public void Del(int id)

	{

		userRep.deleteById(id);

	}

	public UserModel updateUser(UserModel l)

	{

		return userRep.save(l);

	}
}

 

 

 

             

              