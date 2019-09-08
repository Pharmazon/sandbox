package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.alexeyshcheglov.parser.entity.District;

public class DistrictDAO implements DAO<District, Integer> {
    private final SessionFactory factory;

    public DistrictDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final District district) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(district);
            session.getTransaction().commit();
        }
    }

    @Override
    public District read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final District result = session.get(District.class, id);
            if (result != null) {
                Hibernate.initialize(result.getDistrictType());
            }
            return result;
        }
    }

    @Override
    public void update(@NotNull final District district) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(district);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final District district) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(district);
            session.getTransaction().commit();
        }
    }

    public Integer readIdByName(@NotNull final String name) {
        Integer result = 0;
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from District where name = :name");
            query.setParameter("name", name);
            District district = (District) query.getSingleResult();
            result = district.getId();
        }
        return result;
    }
}
