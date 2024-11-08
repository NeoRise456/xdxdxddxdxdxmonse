package pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.commands;

import java.util.Date;

public record CreateWorkOrderCommand(
        String medicalEquipmentId,
        Long staffId,
        Long healthInstitutionId,
        String workType,
        String description,
        Integer priority,
        Float amount,
        Date plannedAt
) {
}
