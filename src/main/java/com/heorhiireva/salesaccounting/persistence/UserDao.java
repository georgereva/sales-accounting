package com.heorhiireva.salesaccounting.persistence;

import com.heorhiireva.salesaccounting.domain.Role;
import com.heorhiireva.salesaccounting.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDao {
//    @Autowired
//    private MongoTemplate mongoTemplate;

    private static Map<String, User> userMap;
    private static List<Role> userRoles;

    static {
        userMap = new HashMap<>();
        userRoles = new ArrayList<>();

        userRoles.add(Role.USER);
        userRoles.add(Role.ADMIN);

        userMap.put("admin", User.builder()
                .username("admin")
                .password(new BCryptPasswordEncoder().encode("1"))
                .authorities(userRoles)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true).build());
    }

    public Optional<User> findByUsername(String username) {
        return Optional.of(userMap.get(username));
    }

    public void saveUser(User user) {
        userMap.put(user.getUsername(), user);
    }

}
