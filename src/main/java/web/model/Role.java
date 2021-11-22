package web.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Имя роли должно соответствовать шаблону: «ROLE_ИМЯ», например, ROLE_USER.
    @Column(name = "role")
    private String rolen;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<User> users  = new ArrayList<>();;

    public Role() {}
    public Role(String role) {
        this.rolen = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return rolen;
    }

    public void setRole(String role) {
        this.rolen = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public String getAuthority() {
        return rolen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role roles = (Role) o;

        if (id != null ? !id.equals(roles.id) : roles.id != null) return false;
        if (rolen != null ? !rolen.equals(roles.rolen) : roles.rolen != null) return false;
        return users != null ? users.equals(roles.users) : roles.users == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (rolen != null ? rolen.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }
}
