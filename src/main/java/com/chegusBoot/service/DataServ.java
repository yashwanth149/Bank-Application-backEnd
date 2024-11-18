package com.chegusBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chegusBoot.beans.BranchCity;
import com.chegusBoot.beans.DataBank;
import com.chegusBoot.beans.DataBranch;
import com.chegusBoot.beans.DataPerson;
import com.chegusBoot.repository.BranchRepo;
import com.chegusBoot.repository.DataRepo;
import com.chegusBoot.repository.PersonRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DataServ {
	@Autowired
	private DataRepo repo;

	@Autowired
	private BranchRepo repo1;

	@Autowired
	private PersonRepo repo2;

	@Autowired
	private EntityManager em;

	@CacheEvict(value = "Banks", allEntries = true)
	@Transactional
	public void persistData(DataBank bank) {
		if (bank.getBid() != null) {
			DataBank existBank = repo.findById(bank.getBid()).get();
			for (DataBranch existBranch : existBank.getLst()) {
				boolean branchExists = false;
				for (DataBranch newBranch : bank.getLst()) {
					if (Objects.equals(newBranch.getBranchId(), existBranch.getBranchId())) {
						branchExists = true;
						for (DataPerson person : existBranch.getSublst()) {
							boolean isPersonExists = false;
							for (DataPerson newPerson : newBranch.getSublst()) {
								if (Objects.equals(person.getPersonId(), newPerson.getPersonId())) {
									isPersonExists = true;
								}
							}
							if (!isPersonExists) {
								repo2.delete(person);
							}
						}
					}

				}
				if (!branchExists) {
					repo1.delete(existBranch);
				}
			}
		}
		repo.save(bank);

		for (DataBranch branch : bank.getLst()) {
			branch.setBank(bank);
			repo1.save(branch);

			for (DataPerson person : branch.getSublst()) {
				person.setBranch(branch);
				repo2.save(person);
			}
		}
	}

	public DataBank fetchData(Long id) {
		return repo.findById(id).get();
	}

	@Cacheable("Banks")
	public List<DataBank> fetchAll() {
		return repo.findAll();
	}

	@CacheEvict(value = "Banks", allEntries = true)
	@Transactional
	public void removeData(Long id) {
		repo.deleteById(id);
	}

	public DataBranch fetchBranchData(Long id) {
		return repo1.findById(id).get();
	}

	public List<DataBank> filerBank(DataBank b) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DataBank> query = cb.createQuery(DataBank.class);
		Root<DataBank> root = query.from(DataBank.class);

		List<Predicate> pre = new ArrayList<>();

		if (b.getBid() != null) {
			pre.add(cb.equal(root.get("bid"), b.getBid()));
		}
		if (b.getMainBranch() != null) {
			pre.add(cb.like(root.get("mainBranch"), "%" + b.getMainBranch() + "%"));
		}
		if (b.getBname() != null) {
			pre.add(cb.like(root.get("bname"), "%" + b.getBname() + "%"));
		}

		query.where(pre.toArray(new Predicate[0]));

		return em.createQuery(query).getResultList();
	}

	public List<DataPerson> getAllPersons(Integer start, Integer count) {
		List<DataPerson> persons = repo2.getPersons(start, count);
		List<DataPerson> listPersons = new ArrayList<>();
		persons.forEach(person -> {
			DataPerson dataPerson = new DataPerson();
			dataPerson.setPersonId(person.getPersonId());
			dataPerson.setPersonName(person.getPersonName());
			listPersons.add(dataPerson);
		});
		return listPersons.size() > 0 ? listPersons : null;
	}

	public List<DataPerson> getPersons() {
		return repo2.findAll();
	}

	public List<DataPerson> debounceSearchName(String b) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DataPerson> query = cb.createQuery(DataPerson.class);
		Root<DataPerson> root = query.from(DataPerson.class);

		List<Predicate> pre = new ArrayList<>();

		if (b != null) {
			pre.add(cb.like(root.get("personName"), "%" + b + "%"));
		}

		query.where(pre.toArray(new Predicate[0]));

		return em.createQuery(query).getResultList();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> commonDropDown(Object obj) {
		Class<T> clazz = null;
		Map<Object, Object> mapUI = (Map<Object, Object>) obj;

		Object object = mapUI.get("className");
		Object object2 = mapUI.get("Params");
		Integer start = (int) mapUI.get("start");
		Integer count = (int) mapUI.get("count");

		try {
			clazz = (Class<T>) Class.forName("com.chegusBoot.beans." + object.toString());
		} catch (Exception e) {
			log.error("Error occurred while creating class instance", e);
		}

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(clazz);
		Root<T> root = criteria.from(clazz);
		List<Selection<?>> selections = new ArrayList<>();

		if (object2 instanceof Map) {
			Map<String, Object> paramsMap = (Map<String, Object>) object2;
			for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
				String paramName = entry.getKey();
				selections.add(root.get(paramName));
			}
		}
		criteria.select(root);
		TypedQuery<T> query = em.createQuery(criteria);

		query.setFirstResult(start);
		query.setMaxResults(count);

		List<T> resultList = query.getResultList();
		return resultList;
	}

}
