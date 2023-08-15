package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Station;

@Repository
public interface StationRepository extends CrudRepository<Station, String> {
	
	@Query(value = "select s.station_name from station_details s", nativeQuery = true)
	List<String> getStationName();
	
}
