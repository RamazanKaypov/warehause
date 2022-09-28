package uz.data.warehause.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Product product;

    @Column(nullable = false)
    private long amount;

    @Column(nullable = false)
    private long price;

    @Column(nullable = false)
    private String expire_date;

    @ManyToOne
    private Input input;


}
