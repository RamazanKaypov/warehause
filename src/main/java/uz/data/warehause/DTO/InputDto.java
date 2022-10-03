package uz.data.warehause.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputDto {

    private Timestamp timestamp;

    private Integer warehauseId;

    private Integer SupplierId;

    private Integer CurrencyId;

    private String facture_number;


}
