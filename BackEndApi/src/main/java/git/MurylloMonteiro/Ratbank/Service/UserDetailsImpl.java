package git.MurylloMonteiro.Ratbank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import git.MurylloMonteiro.Ratbank.Model.UserModel;

public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    UserModel user;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        

        return null;
    }


    
}
