package io.stahlferro.mangorhodes.models.secondary;

import io.stahlferro.mangorhodes.models.primary.Room;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Document
@Getter @Setter @ToString
public class RoomAccess extends BaseSecondaryModel {
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
