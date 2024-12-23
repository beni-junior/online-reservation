package ir.hatami.onlinereservation.domain.model.common;

import ir.hatami.onlinereservation.repository.DoctorRepository;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TimeTrackerListener {

    private static DoctorRepository doctorRepository;

    @Autowired
    public void setDoctorRepository(DoctorRepository doctorRepository) {
        TimeTrackerListener.doctorRepository = doctorRepository;
    }

    @PrePersist
    private void beforeCreation(BaseEntity baseEntity) {
        baseEntity.setCreatedAt(Instant.now().getEpochSecond());
    }

    @PreUpdate
    private void beforeUpdate(BaseEntity baseEntity) {
        baseEntity.setUpdatedAt(Instant.now().getEpochSecond());
    }


}

