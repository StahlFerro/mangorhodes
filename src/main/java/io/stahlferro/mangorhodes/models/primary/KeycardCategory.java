package io.stahlferro.mangorhodes.models.primary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter @Setter @ToString
public class KeycardCategory extends BasePrimaryModel {

    private int accessLevel;

    @ManyToOne
    @JoinColumn
    private Department department;

    @OneToMany
    @JoinColumn
    private Set<Keycard> keyCards;
}
