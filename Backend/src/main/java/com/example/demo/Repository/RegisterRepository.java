package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Register;

import jakarta.transaction.Transactional;

@Repository	
public interface RegisterRepository extends CrudRepository<Register, String> {
   @Query("select r.user_id from Register r")
   public List<String> getListOfUserId();
   
   @Query("select r.email from Register r")
   public List<String> getListOfEmail();
   
   @Query("select r.mobile_no from Register r")
   public List<Integer> getListOfmobileNo();

   @Query("select r.user_id from Register r where r.user_id=?1")
   public List<String> getUserId(String id);
   
   @Query("select r.password from Register r where r.user_id = ?1")
	public String getPassword(String id);

	@Modifying
	@Query(value = "UPDATE register SET password = ?2, confirm_password = ?3  WHERE user_id = ?1", nativeQuery = true)
	@Transactional
	void updatePasswordAndConfirmPassword(String userId, String password, String confirmPassword);
	
	@Query(value = "select * from register where user-id = ?1 ", nativeQuery = true)
	public List<Register> getAllByUserId(String user_id);
  }

