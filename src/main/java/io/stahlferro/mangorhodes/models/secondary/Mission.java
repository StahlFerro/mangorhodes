package io.stahlferro.mangorhodes.models.secondary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.UUID;

@Document
@Getter @Setter @ToString
public class Mission {
    private String code;
    private String objective;
    private String type;
    private long reward;
    private ArrayList<String> operatorCodes;
}
