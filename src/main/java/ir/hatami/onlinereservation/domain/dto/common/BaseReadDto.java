package ir.hatami.onlinereservation.domain.dto.common;

import java.util.UUID;

public abstract class BaseReadDto {
    private UUID id;
    private long createdAt;
    private long updatedAt;

    public BaseReadDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
