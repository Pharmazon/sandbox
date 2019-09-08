package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexeyshcheglov.parser.entity.ResidentialName;

public class ResidentialNameDAO implements DAO<ResidentialName, Integer> {
    private final SessionFactory factory;

    public ResidentialNameDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final ResidentialName residentialName) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(residentialName);
            session.getTransaction().commit();
        }
    }

    @Override
    public ResidentialName read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final ResidentialName result = session.get(ResidentialName.class, id);
            return result != null ? result : new ResidentialName();
        }
    }

    @Override
    public void update(@NotNull final ResidentialName residentialName) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(residentialName);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final ResidentialName residentialName) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(residentialName);
            session.getTransaction().commit();
        }
    }
}
