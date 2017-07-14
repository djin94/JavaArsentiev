package ru.kabatov.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kabatov.models.Role;
import ru.kabatov.store.Storages;

/**
 * TODO: comment
 * @author parsentev
 * @since 30.05.2015
 */
public class DbTool {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Storages storage = context.getBean(Storages.class);
        System.out.println(storage.roleStorage.values());
        storage.roleStorage.add(new Role());
    }
}
