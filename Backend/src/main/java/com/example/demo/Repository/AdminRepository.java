package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AdminDetails;

@Repository
public interface AdminRepository extends CrudRepository<AdminDetails, String>{

	@Query(value = "select a.admin_id from admin_details a", nativeQuery = true)
	public List<String> getListOfAdminId();
	
	@Query(value = "select a.password from admin_details a where a.admin_id = ?1", nativeQuery = true)
	public String getPassword(String id);
}