package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PassDetails;

@Repository
public interface PassDetailsRepository extends CrudRepository<PassDetails,Integer> {
	@Query("select p.passenger_id from PassDetails p order by p.passenger_id desc limit 1")
	public List<Integer> getId();

	@Query(value = "select * from passenger_details where pnr_no = ?1", nativeQuery = true)
	List<PassDetails> findByPnrNo(long pnrNo);
}
