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
public class Keycard extends BasePrimaryModel{

    private long number;

    @ManyToOne
    @JoinColumn
    private KeycardCategory category;
}
