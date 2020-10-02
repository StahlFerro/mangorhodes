package io.stahlferro.mangorhodes.models.secondary;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.stahlferro.mangorhodes.models.primary.Room;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Document
@Getter @Setter @ToString
public class RoomAccess extends _BaseMongoModel {
    public enum AccessType {
        ENTRANCE,
        EXIT
    }
//    private UUID uuid;
    private AccessType accessType;

    @ManyToOne
    @JoinColumn(name = "room_id")
    Room room;
}
