package git.MurylloMonteiro.Ratbank.Service;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import git.MurylloMonteiro.Ratbank.Model.AccountModel;
import git.MurylloMonteiro.Ratbank.Model.DTO.LoginDTO.LoginResponse;
import git.MurylloMonteiro.Ratbank.Model.DTO.UserDTO.UserRequest;
import git.MurylloMonteiro.Ratbank.Model.DTO.UserDTO.UserResponse;
import git.MurylloMonteiro.Ratbank.Model.UserModel;
import git.MurylloMonteiro.Ratbank.Repository.AccountRepository;
import git.MurylloMonteiro.Ratbank.Repository.UserRepository;
import git.MurylloMonteiro.Ratbank.Service.Jwt.JwtService;
import git.MurylloMonteiro.Ratbank.Utilits.PassWordUtil;
import jakarta.transaction.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PassWordUtil passWordUtil;

    @Autowired
    private JwtService JwtService;

    @Transactional
    // Create Account
    public ResponseEntity<String> createAccount(UserRequest user) {

        UserModel userModel = new UserModel();
        AccountModel account = new AccountModel();

        account.setNumberAccount(generateAccountNumber());
        account.setPixkey(user.getCpf());
        account.setDateTimeCreate(LocalDate.now());
        account.setBalance(100);
        account.setNegativeBalance(0);

        userModel.setUsername(user.getUsername());
        userModel.setEmail(user.getEmail());
        // userModel.setDate_birth()
        userModel.setCpf(user.getCpf());
        userModel.setPhone_number(user.getPhone_number());
        userModel.setPassword(passWordUtil.hashPassword(user.getPassword()));
        userModel.setAccount(account);

        accountRepository.save(account);
        userRepository.save(userModel);

        return new ResponseEntity("Create Account", HttpStatus.CREATED);
    }

    // Functin, create Random number for account digits
    public String generateAccountNumber() {
        long number = ThreadLocalRandom.current().nextLong(0, 100_000_0000);
        return String.format("%08d", number);
    }

    // Login Account
    public ResponseEntity<String> loginAccount(String email, String password) {
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email ou senha esta incorreta"));
        // Aqui ele verifica se a senha e a mesmado do banco, so que utilizando o BCrypt
        // ele verifica o hash se e igual
        if (email.equals(user.getEmail()) && passWordUtil.verifyPassWord(password, user.getPassword())) {
            LoginResponse loginR = new LoginResponse();
            loginR.setToken(JwtService.generateToken(user.getId()));
            return new ResponseEntity(loginR, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity("Senha ou email incorreto", HttpStatus.UNAUTHORIZED);
    }

    // Deposits money balance account
    public ResponseEntity<String> depositAccount(String number_account, double value) {

        AccountModel account = accountRepository.findByNumberAccount(number_account)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        if (value <= 0) {
            throw new RuntimeException("valor inserido esta invalido");
        }

        if (account.getNegativeBalance() > 0) {

            // Situação aonde o valor e menor que o saldo negativo em conta, o saldo sera
            // apenas abatido do saldo negativo
            if (account.getNegativeBalance() >= value) {
                account.setNegativeBalance(account.getNegativeBalance() - value);
                accountRepository.save(account);

            }

            // Situação aonde o valor negativo e menor que o saldo depositado, o valor
            // sobresalente e setado no balanco de conta
            account.setBalance(value - account.getNegativeBalance());
            account.setNegativeBalance(0);
            accountRepository.save(account);
        }

        // Situação aonde não tem valor negativo pendente, aonde e so deposito
        account.setBalance(account.getBalance() + value);
        accountRepository.save(account);

        return new ResponseEntity(HttpStatus.OK);
    }

    // WithDraw account
    public ResponseEntity<String> withDrawAccount(String number_account, double value) {

        AccountModel account = accountRepository.findByNumberAccount(number_account)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        // por enquento e regra de negocio não aceita ficar com saldo negativo via
        // saque. mas no futuro tera um "cartao de cretido e ele podera deixar
        // negativado"
        if (value <= 0 || value > account.getBalance()) {
            return new ResponseEntity("valor inserido esta invalido", HttpStatus.NOT_ACCEPTABLE);
        }

        account.setBalance(account.getBalance() - value);
        accountRepository.save(account);

        return new ResponseEntity(HttpStatus.OK);
    }

    // Get allInfo
    public UserResponse getAll(UUID id) {
        UserResponse response = new UserResponse();
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        AccountModel account = accountRepository.findByNumberAccount(user.getAccount().getNumberAccount())
                .orElseThrow(() -> new RuntimeException("Conta não encontrado"));
        response.setUsername(user.getUsername());
        response.setNumberAccount(account.getNumberAccount());
        response.setPixKey(user.getCpf());
        response.setBalance(account.getBalance());
        response.setNegativeBalance(account.getNegativeBalance());
        return response;
    }
}
