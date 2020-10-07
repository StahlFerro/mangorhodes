package io.stahlferro.mangorhodes.models.primary;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.codecs.ObjectIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter @Setter @ToString
@JsonIdentityInfo(generator = JSOGGenerator.class)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Department extends BasePrimaryModel {

    @NotEmpty(message = "Department code must not be empty!")
    @Size(max = 25)
    @Column(length = 25)
    private String code;

    @NotEmpty(message = "Department name must not be empty!")
    @Size(max = 50)
    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    Set<Room> rooms;
}
