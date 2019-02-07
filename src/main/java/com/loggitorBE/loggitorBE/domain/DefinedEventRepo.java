package com.loggitorBE.loggitorBE.domain;


import java.math.BigInteger;
import java.util.ArrayList;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DefinedEventRepo extends CrudRepository<DefinedEvent, Long> {
	
	
	@Query(nativeQuery = true)
	ArrayList<EventsResult> getEventsResult(PageRequest pageRequest);
	
	
	@Query(nativeQuery = true)
	ArrayList<DailyChart> getDailyChart(String date, int limit, int offset);
	
	
	@Query(nativeQuery = true)
	ArrayList<DefinedEventPOJO> getAllDefinedEvent();
	

	
	@Query(value = "SELECT * FROM DEFINED_EVENT WHERE DEFINED_EVENT.ID = ?1", nativeQuery = true)
	DefinedEvent findById(BigInteger id);

	
	
}
