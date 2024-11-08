package pe.medetect.platform.u202110237.si729pc2u202110237.work.interfaces.rest.resources;

import java.util.Date;

public record WorkOrderResource(
        Long id,
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
