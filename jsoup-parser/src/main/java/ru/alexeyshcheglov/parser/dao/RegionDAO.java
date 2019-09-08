package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexeyshcheglov.parser.entity.Region;

public class RegionDAO implements DAO<Region, Integer> {
    private final SessionFactory factory;

    public RegionDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final Region region) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(region);
            session.getTransaction().commit();
        }
    }

    @Override
    public Region read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final Region result = session.get(Region.class, id);
            return result != null ? result : new Region();
        }
    }

    @Override
    public void update(@NotNull final Region region) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(region);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Region region) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(region);
            session.getTransaction().commit();
        }
    }
}
