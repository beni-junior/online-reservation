package ir.hatami.onlinereservation.repository;

import ir.hatami.onlinereservation.domain.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

    @Query(
            value = "SELECT EXISTS(SELECT * FROM tb_appointment ta WHERE( DATE(from_unixtime(ta.date)) = DATE(from_unixtime(:date))) AND ta.time_period = :timePeriod AND ta.doctor_id = :doctorId)",
            nativeQuery = true
    )
    int countOfDuplicateAppointments(@Param("date") long date, @Param("timePeriod") int timePeriod, @Param("doctorId") UUID doctorId);
}
