package io.stahlferro.mangorhodes.models.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Getter @Setter @ToString
public class Keycard {
    @Id
    @Type(type = "uuid-char")
    @Column(length = 36, updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long number;

    @ManyToOne
    @JoinColumn
    private KeycardCategory category;
}
