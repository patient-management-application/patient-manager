package us.shamenramen.patientmanager.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import us.shamenramen.patientmanager.models.User;
import us.shamenramen.patientmanager.models.UserWithRoles;
import us.shamenramen.patientmanager.repositories.UserRepository;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository userDao;

    public UserDetailsLoader(UserRepository userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + email);
        }

        return new UserWithRoles(user);
    }
}