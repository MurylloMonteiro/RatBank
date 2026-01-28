package git.MurylloMonteiro.Ratbank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import git.MurylloMonteiro.Ratbank.Repository.AccountRepository;


@Service
public class TransationService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    public ResponseEntity<String> pixTransition(String pixKeyEnvoy, String pixKeyReceived, double value) {

        var accountEnvoy = accountRepository.findByPixkey(pixKeyEnvoy)
                .orElseThrow(() -> new RuntimeException("Remetente não encontrado"));

        var accountReceived = accountRepository.findByPixkey(pixKeyReceived)
                .orElseThrow(() -> new RuntimeException("Destinatario não encontrado"));

        accountService.withDrawAccount(accountEnvoy.getNumberAccount(), value);
        accountService.depositAccount(accountReceived.getNumberAccount(), value);

        // Criação do Historico de trasação, ainda estou pensando em como vou fazer cada
        // um ter seu historico de trasação, acho que cada conta vai ter que
        // buscar pelo numero da conta e ver as trasaçoes exixtentes, mais isso em
        // produção pode deixar consultas problematicas!


        // TransationModel trasacaoHistory = new TransationModel();

        // trasacaoHistory.setDateTime(LocalDateTime.now());
        // trasacaoHistory.setNumberAccountEnvoy(accountEnvoy.getNumberAccount());
        // trasacaoHistory.setNumberAccoutReceived(accountReceived.getNumberAccount());
        // trasacaoHistory.setPixKeyEnvoy(accountEnvoy.getPixkey());
        // trasacaoHistory.setPixKeyReceived(accountReceived.getPixkey());
        // trasacaoHistory.setTransationValue(value);
        // salva o historico
        // transationRepository.save(trasacaoHistory);

        // Salva os saldos modificados
        accountRepository.save(accountEnvoy);
        accountRepository.save(accountReceived);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
