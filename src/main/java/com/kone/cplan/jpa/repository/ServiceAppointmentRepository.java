package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.ServiceAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceAppointmentRepository extends JpaRepository<ServiceAppointment, Integer> {

	@Query("SELECT s.status" +
		" FROM ServiceAppointment s" +
		" WHERE s.status IS NOT NULL" +
		" GROUP BY s.status" +
		" ORDER BY s.status")
	List<String> getUniqueStatuses();
}
