package pe.medetect.platform.u202110237.si729pc2u202110237.work.infrastructure.persistance.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.aggregates.WorkOrder;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.valueobjects.MedicalEquipmentId;
import pe.medetect.platform.u202110237.si729pc2u202110237.work.domain.model.valueobjects.StaffId;

import java.util.Date;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
    boolean existsByMedicalEquipmentIdAndStaffIdAndPlannedAt(MedicalEquipmentId medicalEquipmentId,
                                                             StaffId staffId,
                                                             Date plannedAt);
}
