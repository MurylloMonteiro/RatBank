package git.MurylloMonteiro.Ratbank.Repository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import git.MurylloMonteiro.Ratbank.Model.AccountModel;



@Repository
public interface AccountRepository extends JpaRepository<AccountModel, UUID> {

    Optional<AccountModel> findByPixkey(String pixkey);
    Optional<AccountModel> findByNumberAccount(String numberAccount);
    
}
