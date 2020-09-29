package io.stahlferro.mangorhodes.models.secondary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.UUID;

@Document
@Getter @Setter @ToString
public class Mission {
    private UUID uuid;
    @Size(max = 20)
    private String code;
    private String objective;
    private String type;
    private long reward;
    private ArrayList<String> operatorCodes;

    public Mission() {
        this.uuid = UUID.randomUUID();
    }
}
