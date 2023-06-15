package org.example.app.services;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.app.domain.User;
import org.example.app.exceptions.UserException;

import java.util.Collection;
import java.util.HashMap;

@NoArgsConstructor
public class UserServiceImpl implements UserService {

    private final HashMap<Long, User> map = new HashMap<>();

    @Override
    public void addUser(User user) {
        map.put(user.getId(), user);
    }

    @Override
    public Collection<User> getUsers() {
        return map.values();
    }

    @Override
    public User getUser(Long id) {
        return map.get(id);
    }

    @Override
    public User editUser(User user) throws UserException {
        try {
            if (user.getId() == null)
                throw new UserException("ID required");

            User userEdit = map.get(user.getId());

            if (userEdit == null)
                throw new UserException("User not found");

            if (user.getEmail() != null) {
                userEdit.setEmail(user.getEmail());
            }

            if (user.getPhone() != null) {
                userEdit.setPhone(user.getPhone());
            }

            if (user.getName() != null) {
                userEdit.setName(user.getName());
            }

            if (user.getId() != null) {
                userEdit.setId(user.getId());
            }

            return user;
        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(Long id) {
        map.remove(id);
    }
}
