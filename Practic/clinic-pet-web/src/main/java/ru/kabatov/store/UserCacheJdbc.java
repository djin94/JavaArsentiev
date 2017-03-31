package ru.kabatov.store;

import ru.kabatov.models.User;

import java.util.Collection;

/**
 * Created by Кабатов on 30.03.2017.
 */
public class UserCacheJdbc implements Storage{
    private static final UserCacheJdbc INSTANCE = new UserCacheJdbc();


    private final Storage storage = new JdbcStorage();

    public static UserCacheJdbc getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<User> values() {
        return INSTANCE.storage.values();
    }

    @Override
    public int add(final User user) {
        return this.storage.add(user);
    }

    @Override
    public void edit(final User user) {
        this.storage.edit(user);
    }

    @Override
    public void delete(final int id) {
        this.storage.delete(id);
    }

    @Override
    public User get(final int id) {
        return this.storage.get(id);
    }

    @Override
    public User findByLogin(final String login) {
        return this.storage.findByLogin(login);
    }

    @Override
    public int generateId() {
        return this.storage.generateId();
    }

    @Override
    public void close() {
        this.storage.close();
    }
}
