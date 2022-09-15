package school.hei.finalexamapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import school.hei.finalexamapi.repository.types.PostgresEnumType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "network_equipment")
@TypeDef(name = "pgsql_enum", typeClass = PostgresEnumType.class)
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NetworkEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Type(type = "pgsql_enum")
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    @NotBlank(message = "Brand may not be blank")
    private String brand;

    @NotBlank(message = "Model may not be blank")
    private String model;

    @Column(name = "ip_address")
    @NotBlank(message = "Ip address may not be blank")
    private String ipAddress;

    @Column(name = "is_active")
    private boolean Active;

    public enum DeviceType {
        SERVER, ROUTER, SWITCH, MODEM
    }
}
