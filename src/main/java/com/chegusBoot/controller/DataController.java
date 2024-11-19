package com.chegusBoot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
/*import org.springframework.web.servlet.view.RedirectView;      ---------redirecting page in springBoot instead Model....dont forget*/

import com.chegusBoot.beans.BranchCity;
import com.chegusBoot.beans.DataBank;
import com.chegusBoot.beans.DataBranch;
import com.chegusBoot.beans.DataPerson;
import com.chegusBoot.beans.LoginData;
import com.chegusBoot.service.DataServ;
import com.chegusBoot.service.IndependentTable;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "*")
public class DataController {
	private final DataServ serv1;
	private final IndependentTable serv2;

	public DataController(DataServ serv, IndependentTable indServ) {
		this.serv1 = serv;
		this.serv2 = indServ;
	}

	@GetMapping("/home")
	public ResponseEntity<List<DataBank>> getBankLst() {
		List<DataBank> banks = serv1.fetchAll();
		return new ResponseEntity<>(banks, HttpStatus.OK);
	}

	@GetMapping("/fetchById/{id}")
	public ResponseEntity<DataBank> getBankById(@PathVariable("id") Long id) {
		DataBank bank = serv1.fetchData(id);
		return new ResponseEntity<>(bank, HttpStatus.OK);
	}

	@PostMapping("/add")
	public void addEmp(@RequestBody DataBank bank) {
		serv1.persistData(bank);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmpById(@PathVariable("id") Long id) {
		serv1.removeData(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getAllPersons")
	public ResponseEntity<List<DataPerson>> getAllPersons(
			@RequestParam(value = "start", defaultValue = "0") Integer start,
			@RequestParam(value = "end", defaultValue = "10") Integer end) {
		List<DataPerson> allPersons = serv1.getAllPersons(start, end);
		return new ResponseEntity<>(allPersons, HttpStatus.OK);
	}
	
	@GetMapping("/getPersons")
	public ResponseEntity<List<DataPerson>> getPersons() {
		List<DataPerson> persons = serv1.getPersons();
		return new ResponseEntity<>(persons, HttpStatus.OK);
	}

	// independent Tables
	@PostMapping("/addbranch")
	public void addEmp(@RequestBody BranchCity city) {
		serv2.persistData(city);
	}

	@GetMapping("/branchlst")
	public ResponseEntity<List<BranchCity>> getBranchCityLst() {
		List<BranchCity> cities = serv2.fetchAll();
		return new ResponseEntity<>(cities, HttpStatus.OK);
	}

	@GetMapping("/cityId/{id}")
	public ResponseEntity<BranchCity> getCityById(@PathVariable("id") Long id) {
		BranchCity city = serv2.fetchData(id);
		return new ResponseEntity<>(city, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCity/{id}")
	public void deleteBranchCity(@PathVariable("id") Long id) {
		serv2.deleteBranch(id);

	}

	@GetMapping("/branchObj/{id}")
	public ResponseEntity<DataBranch> getBranchById(@PathVariable("id") Long id) {
		DataBranch branch = serv1.fetchBranchData(id);
		return new ResponseEntity<>(branch, HttpStatus.OK);
	}

	// Login user details data transfer

	@PostMapping("/userData")
	public void userDataPersist(@RequestBody LoginData user) {
		serv2.persistUser(user);
	}

	@GetMapping("/getUsers")
	public ResponseEntity<List<LoginData>> getUser() {
		List<LoginData> users = serv2.getUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// search with different parameters...

	@PostMapping("/searchField")
	public ResponseEntity<List<DataBank>> searchMehod(@RequestBody DataBank b) {
		List<DataBank> filerBank = serv1.filerBank(b);
		return new ResponseEntity<>(filerBank, HttpStatus.OK);
	}
	
	@PostMapping("/debounceSearch")
	public ResponseEntity<List<DataPerson>> debounceSearch(@RequestBody(required = false) String b) {
		System.out.println(b);
		List<DataPerson> debounceSearchName = serv1.debounceSearchName(b);
		
		return new ResponseEntity<>(debounceSearchName, HttpStatus.OK);
	}
	
	@PostMapping("/common-search")
	public List<?> commonSearch(@RequestBody(required = false) Object obj) {
		List<?> reponse = serv1.commonDropDown(obj);
		return reponse;
		
	}
	
	@PostMapping("on-key-search")
	public List<?> onKeySearchDropDown(@RequestBody(required = false) Object obj) {
		List<?> reponse = serv1.onKeySearchDropDown(obj);
		return reponse;
		
	}
	

}
