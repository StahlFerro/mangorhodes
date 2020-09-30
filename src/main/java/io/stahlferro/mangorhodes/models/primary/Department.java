package io.stahlferro.mangorhodes.models.primary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Getter @Setter @ToString
public class Department {
    @Id
    @Type(type = "uuid-char")
    @Column(length = 36, updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotEmpty(message = "Department code must not be empty!")
    @Size(max = 25)
    @Column(length = 25)
    private String code;

    @NotEmpty(message = "Department name must not be empty!")
    @Size(max = 50)
    @Column(length = 50)
    private String name;
}
