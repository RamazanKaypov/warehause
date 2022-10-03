package uz.data.warehause.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false,unique = true)
        private String phoneNumber;

    @Column(nullable = false,unique = true)
    private String code;

    @Column(nullable = false,unique = true)
    private String password;

    @ManyToMany
    private Set<Warehause> warehauses;

    private Boolean status;

}
