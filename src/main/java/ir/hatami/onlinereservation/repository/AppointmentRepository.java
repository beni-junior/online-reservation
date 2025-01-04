package ir.hatami.onlinereservation.repository;

import ir.hatami.onlinereservation.domain.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

    @Query(
            value = "SELECT EXISTS(SELECT * FROM tb_appointment ta WHERE( DATE(from_unixtime(ta.date)) = DATE(from_unixtime(:dateTime))) AND ta.doctor_id = :doctorId)",
            nativeQuery = true
    )
    int countOfDuplicateAppointments(@Param("dateTime") long date, @Param("timePeriod") int timePeriod, @Param("doctorId") UUID doctorId);

    // fetching all none expired tagged data that getting expired
    @Query(
            value = "SELECT * " +
                    "   FROM tb_appointment ta " +
                    "         JOIN tb_doctor td ON td.id = ta.doctor_id " +
                    "         JOIN tb_patient tp ON tp.id = ta.patient_id " +
                    " WHERE ta.date < :presentTime AND ta.expired = FALSE ",
            nativeQuery = true
    )
    List<Appointment> findAllGettingExpired(@Param("presentTime") long presentTime);
}
