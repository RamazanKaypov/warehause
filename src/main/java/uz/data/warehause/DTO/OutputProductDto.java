package uz.data.warehause.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputProductDto {
    private Integer productId;

    private double amount;

    private double price;

    private Integer outputId;
}
