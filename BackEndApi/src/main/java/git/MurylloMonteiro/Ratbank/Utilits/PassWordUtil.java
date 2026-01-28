package git.MurylloMonteiro.Ratbank.Utilits;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class PassWordUtil {

    private static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder(12);

    public static String hashPassword(String senha) {
        return encoder.encode(senha);
    }

    public static boolean verifyPassWord(String senhaDigitada, String hashSalvo) {
    return encoder.matches(senhaDigitada, hashSalvo);
}

}
