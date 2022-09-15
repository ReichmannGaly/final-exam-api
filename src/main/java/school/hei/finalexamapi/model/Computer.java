package school.hei.finalexamapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "computer")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Brand may not be blank")
    private String brand;

    @NotBlank(message = "Model may not be blank")
    private String model;

    @NotBlank(message = "CPU may not be null")
    private String cpu;

    @NotNull(message = "Ram Capacity may not be null")
    @Column(name = "ram_capacity")
    private int ramCapacity;

    @NotBlank(message = "Operating system ma not be null")
    @Column(name = "operating_system")
    private String operatingSystem;

    @Column(name = "ip_address")
    private String ipAddress;

    @ManyToOne
    @JoinColumn(name = "principal_user_id",nullable = false)
    private User principalUser;

    @Column(name = "is_operational")
    @NotNull(message = "operational cannot be null")
    private boolean operational;
}
