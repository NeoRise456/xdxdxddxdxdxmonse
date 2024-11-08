package pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.services;

import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.aggregates.WorkOrder;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.commands.CreateWorkOrderCommand;

import java.util.Optional;

public interface WorkOrderCommandService {
    Optional<WorkOrder> handle(CreateWorkOrderCommand command);
}
