package pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StaffId(Long staffId) {
    public StaffId {
        if (staffId == null) {
            throw new IllegalArgumentException("StaffId cannot be null");
        }
        if (staffId <= 0) {
            throw new IllegalArgumentException("StaffId less than or equal to 0");
        }
    }
}
