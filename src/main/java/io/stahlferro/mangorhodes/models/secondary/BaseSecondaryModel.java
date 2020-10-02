package io.stahlferro.mangorhodes.models.secondary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @ToString
public class _BaseSecondaryModel implements Serializable {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID uuid;
    @CreatedDate
    private LocalDateTime creationTimeStamp;
    @LastModifiedDate
    private LocalDateTime modificationTimeStamp;
    public _BaseSecondaryModel() { this.uuid = UUID.randomUUID(); }
}
