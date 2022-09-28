package uz.data.warehause.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String code;

    private String password;

    private List<Integer> warehauseIds;

    private Boolean status;

}
