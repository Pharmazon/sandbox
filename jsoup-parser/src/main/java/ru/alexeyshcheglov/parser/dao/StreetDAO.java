package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexeyshcheglov.parser.entity.Street;

public class StreetDAO implements DAO<Street, Integer> {
    private final SessionFactory factory;

    public StreetDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final Street street) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(street);
            session.getTransaction().commit();
        }
    }

    @Override
    public Street read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final Street result = session.get(Street.class, id);
            if (result != null) {
                Hibernate.initialize(result.getStreetType());
            }
            return result;
        }
    }

    @Override
    public void update(@NotNull final Street street) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(street);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Street street) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(street);
            session.getTransaction().commit();
        }
    }
}
