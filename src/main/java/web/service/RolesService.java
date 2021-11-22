package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface RolesService {
    List<Role> allread();
    void save(Role roles);
//    Roles show(int id);
//    void update(int id, Roles rolesnew);
    void delete(Role role);

    Role getRole(Long id);
}
