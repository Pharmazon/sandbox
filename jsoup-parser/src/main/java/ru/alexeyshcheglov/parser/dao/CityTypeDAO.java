package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexeyshcheglov.parser.entity.CityType;

public class CityTypeDAO implements DAO<CityType, Integer> {
    private final SessionFactory factory;

    public CityTypeDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final CityType cityType) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(cityType);
            session.getTransaction().commit();
        }
    }

    @Override
    public CityType read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final CityType result = session.get(CityType.class, id);
            if (result != null) {
                Hibernate.initialize(result.getCities());
            }
            return result;
        }
    }

    @Override
    public void update(@NotNull final CityType cityType) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(cityType);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final CityType cityType) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(cityType);
            session.getTransaction().commit();
        }
    }
}
