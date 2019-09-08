package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexeyshcheglov.parser.entity.HouseType;

public class HouseTypeDAO implements DAO<HouseType, Integer> {
    private final SessionFactory factory;

    public HouseTypeDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final HouseType houseType) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(houseType);
            session.getTransaction().commit();
        }
    }

    @Override
    public HouseType read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final HouseType result = session.get(HouseType.class, id);
            return result != null ? result : new HouseType();
        }
    }

    @Override
    public void update(@NotNull final HouseType houseType) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(houseType);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final HouseType houseType) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(houseType);
            session.getTransaction().commit();
        }
    }
}