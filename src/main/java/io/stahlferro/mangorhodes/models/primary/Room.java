package io.stahlferro.mangorhodes.models.primary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.security.Key;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter @Setter @ToString
public class Room {
    @Id
    @Type(type = "uuid-char")
    @Size(max = 36)
    @Column(length = 36, updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    private int accessLevel;

    @ManyToOne
    @JoinColumn
    private Department department;

    public boolean accessAllowed(Keycard keycard) {
        KeycardCategory cardCateg = keycard.getCategory();
        Department cardDept = cardCateg.getDepartment();
        int cardAccessLvl = cardCateg.getAccessLevel();
        return this.department.equals(cardDept) && this.accessLevel <= cardAccessLvl;
    }
}
