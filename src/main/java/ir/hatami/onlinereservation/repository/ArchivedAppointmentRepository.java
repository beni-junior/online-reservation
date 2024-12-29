package ir.hatami.onlinereservation.repository;

import ir.hatami.onlinereservation.domain.model.ArchivedAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivedAppointmentRepository extends JpaRepository<ArchivedAppointment, Long> {
}
