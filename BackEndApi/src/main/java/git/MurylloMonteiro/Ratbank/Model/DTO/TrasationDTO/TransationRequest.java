package git.MurylloMonteiro.Ratbank.Model.DTO.TrasationDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransationRequest {

    private String pixEnvoy;
    private String pixReceived;
    private Double value;
}
