package pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.medetect.platform.u202110237.si729pc2u202110237.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.commands.CreateWorkOrderCommand;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.valueobjects.HealthInstitutionId;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.valueobjects.MedicalEquipmentId;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.valueobjects.StaffId;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.valueobjects.WorkTypes;

import java.util.Date;

@Getter
@Entity
@Table(name = "work_orders")
public class WorkOrder extends AuditableAbstractAggregateRoot<WorkOrder> {

    @NotNull
    @Embedded
    private MedicalEquipmentId medicalEquipmentId;

    @NotNull
    @Embedded
    private StaffId staffId;

    @NotNull
    @Embedded
    private HealthInstitutionId healthInstitutionId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private WorkTypes workType;

    @NotNull
    @Column(length = 200)
    private String description;

    @Min(1)
    @Max(3)
    @NotNull
    private Integer priority;

    @Min(0)
    @NotNull
    private Float amount;

    @NotNull
    @Column(nullable = false)
    private Date plannedAt;

    public WorkOrder() {

    }

    public WorkOrder(CreateWorkOrderCommand command){
        this.medicalEquipmentId = new MedicalEquipmentId(command.medicalEquipmentId());
        this.staffId = new StaffId(command.staffId());
        this.healthInstitutionId = new HealthInstitutionId(command.healthInstitutionId());
        this.workType = WorkTypes.valueOf(command.workType().toUpperCase());
        this.description = command.description();
        this.priority = command.priority();
        this.amount = command.amount();
        this.plannedAt = command.plannedAt();
    }


}
