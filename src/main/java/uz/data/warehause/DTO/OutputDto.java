package uz.data.warehause.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputDto {

    private Timestamp timestamp;

    private Integer warehauseId;

    private Integer currencyId;

    private String facture_number;

    private Integer clientId;

}
