package git.MurylloMonteiro.Ratbank.Model.DTO.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithDrawRequest {
    private String numberAccount;
    private Double value;
}
