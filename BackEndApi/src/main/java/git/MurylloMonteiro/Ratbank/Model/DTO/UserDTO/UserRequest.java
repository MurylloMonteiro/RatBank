package git.MurylloMonteiro.Ratbank.Model.DTO.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String username;
    private String email;
    private String numberAccount;
    private String phone_number;
    private String cpf;
    private String password;
}
