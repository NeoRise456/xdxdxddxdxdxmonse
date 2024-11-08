package pe.medetect.platform.u202110237.si729pc2u202110237.work.interfaces.rest;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.services.WorkOrderCommandService;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.interfaces.rest.resources.CreateWorkOrderResource;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.interfaces.rest.resources.WorkOrderResource;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.interfaces.rest.transform.CreateWorkOrderCommandFromResourceAssembler;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.interfaces.rest.transform.WorkOrderResourceFromEntityAssembler;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST})
@RestController
@RequestMapping(value = "/api/v1/medical-equipments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Work Orders", description = "Work Orders Management Endpoints")
public class WorkOrderController {

    private final WorkOrderCommandService workOrderCommandService;

    public WorkOrderController(WorkOrderCommandService workOrderCommandService) {
        this.workOrderCommandService = workOrderCommandService;
    }

    @PostMapping("/{medicalEquipmentId}/work-orders")
    @ApiResponse(responseCode = "201", description = "Work Order created")
    public ResponseEntity<WorkOrderResource> createWorkOrder(@PathVariable String medicalEquipmentId,
                                                             @RequestBody CreateWorkOrderResource resource){

        var createWorkOrderCommand = CreateWorkOrderCommandFromResourceAssembler.toCommandFromResource(resource, medicalEquipmentId);

        var workOrder = this.workOrderCommandService.handle(createWorkOrderCommand);

        if (workOrder.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var workOrderResource = WorkOrderResourceFromEntityAssembler.toResourceFromEntity(workOrder.get());

        return new ResponseEntity<>(workOrderResource, HttpStatus.CREATED);
    }

}
