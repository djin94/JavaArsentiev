package ru.kabatov.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO: comment
 * @author parsentev
 * @since 30.05.2015
 */
@Service
public class Storages {
    public final HibernateStorage userStorage;

    public final RoleDAO roleStorage;

    public final MessageStorage messageStorage;

    @Autowired
    public Storages(final HibernateStorage userStorage, final RoleDAO roleStorage, final MessageStorage messageStorage) {
        this.userStorage = userStorage;
        this.roleStorage = roleStorage;
        this.messageStorage = messageStorage;
    }
}
