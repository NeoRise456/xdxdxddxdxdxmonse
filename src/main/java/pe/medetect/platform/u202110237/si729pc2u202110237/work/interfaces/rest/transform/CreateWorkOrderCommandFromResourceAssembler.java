package pe.medetect.platform.u202110237.si729pc2u202110237.work.interfaces.rest.transform;

import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.commands.CreateWorkOrderCommand;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.interfaces.rest.resources.CreateWorkOrderResource;

public class CreateWorkOrderCommandFromResourceAssembler {
    public static CreateWorkOrderCommand toCommandFromResource(CreateWorkOrderResource resource, String medicalEquipmentId) {
        return new CreateWorkOrderCommand(
                medicalEquipmentId,
                resource.staffId(),
                resource.healthInstitutionId(),
                resource.workType(),
                resource.description(),
                resource.priority(),
                resource.amount(),
                resource.plannedAt()
        );
    }
}
