package git.MurylloMonteiro.Ratbank.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import git.MurylloMonteiro.Ratbank.Model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findById(UUID id);

    Optional<UserModel> findByEmail(String email);

}
