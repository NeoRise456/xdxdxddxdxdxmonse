package pe.medetect.platform.u202110237.si729pc2u202110237.work.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.aggregates.WorkOrder;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.commands.CreateWorkOrderCommand;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.valueobjects.MedicalEquipmentId;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.valueobjects.StaffId;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.services.WorkOrderCommandService;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.infrastructure.persistance.jpa.repositories.WorkOrderRepository;

import java.util.Optional;

@Service
public class WorkOrderCommandServiceImpl implements WorkOrderCommandService {

    private final WorkOrderRepository workOrderRepository;

    public WorkOrderCommandServiceImpl(WorkOrderRepository workOrderRepository) {
        this.workOrderRepository = workOrderRepository;
    }

    @Override
    public Optional<WorkOrder> handle(CreateWorkOrderCommand command) {


        if(this.workOrderRepository.existsByMedicalEquipmentIdAndStaffIdAndPlannedAt(
                new MedicalEquipmentId(command.medicalEquipmentId()),
                new StaffId(command.staffId()),
                command.plannedAt()
        )) {
            throw new IllegalArgumentException("Work order already exists for the given medical equipment, staff and planned date");
        }

        var newWorkOrder = new WorkOrder(command);

        var result = this.workOrderRepository.save(newWorkOrder);

        return Optional.of(result);
    }
}
