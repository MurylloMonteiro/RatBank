package git.MurylloMonteiro.Ratbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import git.MurylloMonteiro.Ratbank.Model.DTO.TrasationDTO.TransationRequest;
import git.MurylloMonteiro.Ratbank.Service.TransationService;

@RestController
@RequestMapping("/transation")
public class TrasationController {

    @Autowired
    private TransationService transationService;

    @PostMapping
    public ResponseEntity<String> pixTrasation(@RequestBody TransationRequest trasationR){
        return transationService.pixTransition(trasationR.getPixEnvoy(), trasationR.getPixReceived(), trasationR.getValue());
    }

    //Here have trasation methods between users 

    //in future implements TED trasation, using number account for trasation other banks

}
