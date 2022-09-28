package uz.data.warehause.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String date;

    @ManyToOne
    private Warehause warehause;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Currency currency;

    @Column(nullable = false,unique = true)
    private String facture_number;

    @Column(nullable = false,unique = true)
    private String code;


}
