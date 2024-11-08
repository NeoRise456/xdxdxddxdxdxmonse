package pe.medetect.platform.u202110237.si729pc2u202110237.work.interfaces.rest.transform;

import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.aggregates.WorkOrder;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.interfaces.rest.resources.WorkOrderResource;

public class WorkOrderResourceFromEntityAssembler {
    public static WorkOrderResource toResourceFromEntity(WorkOrder entity) {
        return new WorkOrderResource(
                entity.getId(),
                entity.getMedicalEquipmentId().medicalEquipmentId(),
                entity.getStaffId().staffId(),
                entity.getHealthInstitutionId().healthInstitutionId(),
                entity.getWorkType().toString(),
                entity.getDescription(),
                entity.getPriority(),
                entity.getAmount(),
                entity.getPlannedAt()
        );
    }
}
