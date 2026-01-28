package git.MurylloMonteiro.Ratbank.Model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Entity
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable= false, unique = true)
    private String numberAccount;

    @Column(nullable= false, unique = true)
    private String pixkey;
    
    private LocalDate dateTimeCreate;
    
    private double balance;
    
    private double negativeBalance;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private UserModel person;

}
