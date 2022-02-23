package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserRepository;
import web.model.User;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User readUser(long id) {
        return userRepository.readUser(id);
    }

    @Override
    public User deleteUser(long id) {
        return userRepository.deleteUser(id);
    }


    @Override
    public void createOrUpdateUser(User user) {
        if (Objects.isNull(user.getId())) {
            createUser(user);
        } else {
            updateUser(user);
        }

    }

    private void createUser(User user) {
        userRepository.createUser(user);
    }

    private void updateUser(User user) {
        userRepository.updateUser(user);
    }
}

