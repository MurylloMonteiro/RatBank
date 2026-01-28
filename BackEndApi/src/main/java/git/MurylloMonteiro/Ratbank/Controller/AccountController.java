package git.MurylloMonteiro.Ratbank.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import git.MurylloMonteiro.Ratbank.Model.DTO.Account.DepositRequest;
import git.MurylloMonteiro.Ratbank.Model.DTO.Account.WithDrawRequest;
import git.MurylloMonteiro.Ratbank.Model.DTO.UserDTO.UserResponse;
import git.MurylloMonteiro.Ratbank.Service.AccountService;
import git.MurylloMonteiro.Ratbank.Service.Jwt.JwtService;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtService jwtService;

    @PutMapping("/deposit")
    public ResponseEntity<String> depositAccount(@RequestBody DepositRequest deposit) {
        return accountService.depositAccount(deposit.getNumberAccount(), deposit.getValue());
    }

    @PutMapping("/withdraw")
    public ResponseEntity<String> withDrawAccount(@RequestBody WithDrawRequest withDrawRequest){
        return accountService.withDrawAccount(withDrawRequest.getNumberAccount(), withDrawRequest.getValue());
    }
    

    //GetallInfos
    @GetMapping 
    public ResponseEntity<UserResponse> getAllInfos(@RequestHeader("Authorization") String authorization ){
        //Aqui ele esta pegando o campo autorization com o bearer token 
        String token = authorization.replace("Bearer ", "");
        var jwt = jwtService.getClaims(token);
        var user = accountService.getAll(UUID.fromString(jwt.getSubject()));
        return new ResponseEntity(user, HttpStatus.ACCEPTED);
    }
   
}
