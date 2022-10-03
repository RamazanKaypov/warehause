package uz.data.warehause.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputProductDto {

    private Integer productId;

    private double amount;

    private double price;

    private Integer inputId;

    private Date expire_date;
}
