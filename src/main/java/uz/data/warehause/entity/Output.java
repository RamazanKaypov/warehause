package uz.data.warehause.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Timestamp timestamp;

    @ManyToOne
    private Warehause warehause;

    @ManyToOne
    private Currency currency;

    @Column(nullable = false,unique = true)
    private String facture_number;

    @Column(nullable = false,unique = true)
    private String code;

    @ManyToOne
    private Client client;
}
