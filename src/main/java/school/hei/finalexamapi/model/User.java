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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "\"user\"")
@TypeDef(name = "pgsql_enum", typeClass = PostgresEnumType.class)
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "First name may not be blank")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name may not be blank")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "username may not be blank")
    private String username;

    @Email
    private String email;

    @NotBlank(message = "password may not be blank")
    private String password;

    @Type(type = "pgsql_enum")
    @Enumerated(EnumType.STRING)
    private Role role;
    public enum Role {
        ADMIN, EMPLOYEE
    }
}
