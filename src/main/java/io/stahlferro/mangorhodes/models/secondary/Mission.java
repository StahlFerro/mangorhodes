package io.stahlferro.mangorhodes.models.secondary;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.stahlferro.mangorhodes.annotations.Decimal128;
import io.stahlferro.mangorhodes.deserializers.LocalDateOptionalTimeDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Document
@Getter @Setter @ToString
public class Mission extends BaseSecondaryModel {
    @Size(max = 20)
    private String code;
    private String objective;
    private String type;
    @Decimal128
    private BigDecimal reward;
    private ArrayList<String> operatorCodes;
    @JsonDeserialize(using = LocalDateOptionalTimeDeserializer.class)
    private LocalDateTime startDate;
}
