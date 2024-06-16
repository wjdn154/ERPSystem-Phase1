package src.main.java.com.erp.system.production.model.equipment_management;

import java.time.LocalDate;
import java.util.UUID;


// 설비 유지보수 이력

public class MaintenanceHistory {

    private final String id; // 유지보수 ID
    private final String code; // 유지보수 CODE
    private final String equipmentId; // 설비 ID

    private LocalDate maintenanceDate; // 유지보수 일자
    private String description; // 유지보수 설명

    public MaintenanceHistory(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.equipmentId = builder.equipmentId;
        this.maintenanceDate = builder.maintenanceDate;
        this.description = builder.description;
    }

    public static class Builder {
        private final String id; // 유지보수 ID
        private final String code; // 유지보수 CODE
        private final String equipmentId; // 설비 ID

        private LocalDate maintenanceDate; // 유지보수 일자
        private String description; // 유지보수 설명

        public Builder(String code, String equipmentId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.equipmentId = equipmentId;
        }

        public Builder maintenanceDate(LocalDate maintenanceDate) {
            this.maintenanceDate = maintenanceDate;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public MaintenanceHistory build() {
            return new MaintenanceHistory(this);
        }
    } // end of Builder

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }

    public String getDescription() {
        return description;
    }
}