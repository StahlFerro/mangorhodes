package io.stahlferro.mangorhodes.models.secondary;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.stahlferro.mangorhodes.deserializers.LocalDateOptionalTimeDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    @JsonDeserialize(using = LocalDateOptionalTimeDeserializer.class)
    private LocalDateTime startDate
    @CreationTimestamp
    private Timestamp creationTimeStamp;
    @UpdateTimestamp
    private Timestamp modificationTimeStamp;


    public Mission() {
        this.uuid = UUID.randomUUID();
    }
}
