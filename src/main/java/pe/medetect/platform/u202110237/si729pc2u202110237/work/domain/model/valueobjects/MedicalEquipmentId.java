package pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record MedicalEquipmentId(String medicalEquipmentId) {
    public MedicalEquipmentId {
        if (medicalEquipmentId == null) {
            throw new IllegalArgumentException("Medical equipment id cannot be null ");
        }
        if (medicalEquipmentId.isBlank()) {
            throw new IllegalArgumentException("Medical equipment id cannot be empty");
        }
        if (medicalEquipmentId.length() >= 100) {
            throw new IllegalArgumentException("Medical equipment id cannot be longer than 100 characters");
        }

    }
}
