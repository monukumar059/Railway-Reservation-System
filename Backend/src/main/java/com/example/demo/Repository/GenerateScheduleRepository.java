package com.example.demo.Repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.GenerateSchedule;
import com.example.demo.entity.Trains;

import jakarta.transaction.Transactional;


@Repository
public interface GenerateScheduleRepository extends CrudRepository<GenerateSchedule,Integer>{
	@Query(value="SELECT t.train_number from Train_details t where t.train_number NOT IN"+ 
		       "(select train_number from Train_schedule2)", nativeQuery=true)
		public List<Integer> getTrainNo();
	
	@Query(value="SELECT t.route_number from route_details t ", nativeQuery=true)
		public Set<Integer> getRouteNo();
	
	@Query(value="SELECT t.average_speed from train_details t where t.train_number=?  ", nativeQuery=true)
	public float getSpeedOfTrain(int train_no);
	
	@Query(value = "select DISTINCT train_number from Train_schedule2 ORDER BY train_number", nativeQuery = true)
	public List<Long> trianNoByTrain_schedule2();
	
	@Query(value="SELECT g FROM train_schedule2 g WHERE g.station_name =?1 AND g.train_number = ?2", nativeQuery=true)
	public List<Object> getSourceStation(String SourceStaion,int train_no);
	
	@Query(value="SELECT g FROM train_schedule2 g WHERE g.station_name =?1 AND g.train_number = ?2", nativeQuery=true)
	public List<Object> getDestiStaion(String DestiStaion,int train_no);
	
	@Query(value="select td.total_2a_seats from train_details td where td.train_number=?1", nativeQuery=true)
	public String get2ATotalSeats(int train_no);
	
	@Query(value="select * from train_details td where td.train_number=?1", nativeQuery=true)
	public Trains getTrainName(int train_no);
	
	@Query(value="select distinct td.train_number from train_schedule2 td", nativeQuery=true)
	public List<Integer> getTrains();

	@Query(value="select distinct   ts.id,ts.train_number, ts.route_number,rd.station_code, ts.station_name,\r\n"
			+ "ts.arrival_time,ts.departure_time,rd.distance from train_schedule2  ts join route_details  rd on \r\n"
			+ "rd.station_name=ts.station_name where ts.train_number=?1  order by ts.id,rd.distance\r\n"
			+ "", nativeQuery=true)
	public List<Object> findByTrainNo(int train_no);
 
	@Query(value="select td.total_3a_seats from train_details td where td.train_number=?1", nativeQuery=true)
	public String get3ATotalSeats(int train_no); 
	@Modifying
	@Query(value="update train_details  set total_2a_seats=?1 where train_number=?2", nativeQuery=true)
	@Transactional
	public int update2ASeats(int seats,int train_no); 
	
	@Query(value="update train_details  set total_3a_seats=?1 where train_number=?2", nativeQuery=true)
	@Transactional
	public int update3ASeats(int seats,int train_no);  
	 
	@Query(value="select * from train_schedule2 as ts order by ts.id",nativeQuery=true)
	public List<GenerateSchedule> getAllSchedule();
	

}

