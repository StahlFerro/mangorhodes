package io.stahlferro.mangorhodes.models.primary;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.security.Key;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter @Setter @ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Room extends BasePrimaryModel {

    private static final long serialVersionUID = 1L;

    private String name;

    private int accessLevel;

    @ManyToOne
//    @JsonManagedReference
    @JoinColumn(name = "department_id")
    Department department;

    public boolean accessAllowed(Keycard keycard) {
        KeycardCategory cardCateg = keycard.getCategory();
        Department cardDept = cardCateg.getDepartment();
        int cardAccessLvl = cardCateg.getAccessLevel();
        return this.department.equals(cardDept) && this.accessLevel <= cardAccessLvl;
    }
}
