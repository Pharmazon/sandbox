package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexeyshcheglov.parser.entity.DistrictType;

public class DistrictTypeDAO implements DAO<DistrictType, Integer> {
    private final SessionFactory factory;

    public DistrictTypeDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final DistrictType districtType) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(districtType);
            session.getTransaction().commit();
        }
    }

    @Override
    public DistrictType read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final DistrictType result = session.get(DistrictType.class, id);
            if (result != null) {
                Hibernate.initialize(result.getDistricts());
            }
            return result;
        }
    }

    @Override
    public void update(@NotNull final DistrictType districtType) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(districtType);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final DistrictType districtType) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(districtType);
            session.getTransaction().commit();
        }
    }
}
