package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.repositories.RoleRepository;

import java.util.List;
import java.util.Set;

@Service
public class RolesServiceImpl implements RolesService{
    private final RoleRepository roleRepository;

    @Autowired
    public RolesServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public List<Role> allread() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Role roles) {
        roleRepository.save(roles);
    }

//    @Override
//    @Transactional
//    public Roles show(int id) {
//        return roleDao.show(id);
//    }
//
//    @Override
//    @Transactional
//    public void update(int id, Roles rolesnew) {
//        roleDao.update(id,rolesnew);
//    }

    @Override
    @Transactional
    public void delete(Role roles) {
        roleRepository.delete(roles);
    }

    @Override
    @Transactional
    public Role getRole(Long id) {
        return roleRepository.getById(id);
    }
}
