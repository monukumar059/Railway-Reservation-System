package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long>{

//	Distance findBystation_name(Route station_name);
	
	@Query(value = "select * from route_details r where r.station_name = ?1", nativeQuery = true)
	List<Route> findByAllStation_name(String station_name);
	
	@Query(value = "SELECT r.distance FROM route_details r WHERE r.station_name = ?1", nativeQuery = true)
	Integer findByStation_name(String station_name);
	
	@Query(value = "SELECT * FROM route_details r order by r.id,r.route_order", nativeQuery = true)
	List<Route> getAllRoutes();

}
 