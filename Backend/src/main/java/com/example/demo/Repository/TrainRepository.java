package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Trains;

@Repository
public interface TrainRepository extends CrudRepository<Trains, Long> {

	@Query(value = "select t.train_type from train_details t where t.train_number = ?1", nativeQuery = true)
	String findBytrain_number(long train_number);
	
	//API to get train details that are not assigned to any route.
	@Query(value="SELECT * from Train_details t where t.train_number NOT IN"+ 
	       "(select train_number from Train_schedule)", nativeQuery=true)
	public List<Trains> getNoRouteTrain();
	
	@Query(value = "select t.train_number from train_details t", nativeQuery = true)
	List<Long> gettrain_number();

	@Query(value="select distinct ts.train_number from train_schedule2  ts where ts.station_name=?1 or ts.station_name=?2", nativeQuery=true)
	public List<Integer> getTrainBetweenStation(String SourceStaion,String Destinationstation);

	@Query(value="SELECT g.train_number FROM train_schedule2 g WHERE g.station_name in(?1,?2)", nativeQuery=true)
	public List<Object> getListOfTrain(String SourceStaion,String Destinationstation);
    
	@Query(value="select * from train_details as td where train_number=?1", nativeQuery=true)
	public Trains getTrainBetweenStations(int trainNo);
	
}
