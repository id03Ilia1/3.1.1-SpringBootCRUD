package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> allread();
    void save(User user);
    User show (long id);
    void update(User usernew);
    void delete(long id);

    @Override
    User loadUserByUsername(String username) throws UsernameNotFoundException;
}
