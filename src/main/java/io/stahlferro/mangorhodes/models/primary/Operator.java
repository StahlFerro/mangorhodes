package io.stahlferro.mangorhodes.models.primary;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.stahlferro.mangorhodes.deserializers.LocalDateOptionalTimeDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter @Setter @ToString
public class Operator {
    @Id
    @Type(type = "uuid-char")
    @Column(length = 36, updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String code;
    private String codeName;
    private int accessLevel;
    @JsonDeserialize(using = LocalDateOptionalTimeDeserializer.class)
    private LocalDateTime hireDate;
    @CreationTimestamp
    private Timestamp creationTimeStamp;
    @UpdateTimestamp
    private Timestamp modificationTimeStamp;
    private BigDecimal bloodOriginiumCount;

    @OneToMany
    @JoinColumn
    private Set<Keycard> keycards;
}
