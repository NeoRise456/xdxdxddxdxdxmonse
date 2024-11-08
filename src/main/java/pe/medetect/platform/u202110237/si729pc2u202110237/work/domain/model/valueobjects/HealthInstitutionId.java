package pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record HealthInstitutionId(Long healthInstitutionId) {
    public HealthInstitutionId {
        if (healthInstitutionId == null) {
            throw new IllegalArgumentException("HealthInstitutionId cannot be null");
        }
        if (healthInstitutionId <= 0) {
            throw new IllegalArgumentException("HealthInstitutionId less than or equal to 0");
        }
    }
}
