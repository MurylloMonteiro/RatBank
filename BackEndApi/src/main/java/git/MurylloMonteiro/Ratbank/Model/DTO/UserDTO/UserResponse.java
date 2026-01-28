package git.MurylloMonteiro.Ratbank.Model.DTO.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private String username;

    private String numberAccount;
    private String pixKey;
    
    private Double balance;
    private Double negativeBalance;

    

}
