package com.chegusBoot.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.chegusBoot.beans.BranchCity;
import com.chegusBoot.beans.BranchName;
import com.chegusBoot.beans.LoginData;
import com.chegusBoot.repository.BranchCityRepo;
import com.chegusBoot.repository.BranchNameRepo;
import com.chegusBoot.repository.LoginRepo;

@Service
public class IndependentTable {
	private final BranchCityRepo repo1;
	private final BranchNameRepo repo2;
	private final LoginRepo repo3;

	private IndependentTable(BranchCityRepo repo1,BranchNameRepo repo2,LoginRepo repo3) {
		this.repo1 = repo1;
		this.repo2 = repo2;
		this.repo3 = repo3;
	}

//	public void persistData(BranchCity branch) {
//		
//		repo1.save(branch);
//		if(!Objects.isNull(branch.getcId())) {
//			BranchCity branchDB = repo1.findById(branch.getcId()).get();
//			branch.getClst().forEach(x->{
//				x.setCity(branch);
//				repo2.save(x);
//			});
//			List<BranchName> clstDB = branchDB.getClst();
//			List<BranchName> clstUI = branch.getClst();
//			if(!Objects.isNull(clstDB)) {
//				clstDB.forEach(x->{
//					if(!clstUI.contains(x)) {
//						repo2.deleteById(x.getBnameId());
//					}
//				});
//			}
//		}
//		
//	}
	public void persistData(BranchCity branch) {
	    repo1.save(branch);
	    List<BranchName> clstUI = branch.getClst();
	    if (!Objects.isNull(branch.getcId())) {
	        BranchCity branchDB = repo1.findById(branch.getcId()).get();
	        branch.getClst().forEach(x -> {
	            x.setCity(branch);
	            repo2.save(x);
	        });
	        List<BranchName> clstDB = branchDB.getClst();
	        if (!Objects.isNull(clstDB)) {
	            clstDB.forEach(dbItem -> {
	                boolean foundInUI = clstUI.stream().anyMatch(uiItem -> uiItem.getBnameId().equals(dbItem.getBnameId()));
	                if (!foundInUI) {
	                    repo2.deleteById(dbItem.getBnameId());
	                }
	            });
	        }
	    }
	}



	public List<BranchCity> fetchAll() {
		return repo1.findAll();
	}

	
	public void deleteBranch(Long id) {
		repo1.deleteById(id);
	}
	
	public BranchCity fetchData(Long id) {
		return repo1.findById(id).get();
	}

	public void persistUser(LoginData user) {
		repo3.save(user);
	}

	public List<LoginData> getUsers() {
		return repo3.findAll();
	}



}
