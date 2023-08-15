package com.example.demo.Repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Fare;


@Repository
@ComponentScan
public interface FareRepository extends CrudRepository<Fare, Long>{
	
	@Query(value = "select f.fare from fare_details f where f.train_type = (?1) and f.coach_type = (?2)", nativeQuery = true)
	Integer findByTrainType(String train_type, String coach_type);
	
}
