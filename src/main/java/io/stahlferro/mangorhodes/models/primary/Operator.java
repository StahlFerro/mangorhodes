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
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Getter @Setter @ToString
public class Operator {
    @Id
    @Type(type = "uuid-char")
    @Size(max = 36)
    @Column(length = 36, updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String code;
    private String codeName;
    private int accessLevel;
}
