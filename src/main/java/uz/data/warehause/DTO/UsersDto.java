package uz.data.warehause.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String password;

    private Set<Integer> warehauseIds;

    private Boolean status;

}
