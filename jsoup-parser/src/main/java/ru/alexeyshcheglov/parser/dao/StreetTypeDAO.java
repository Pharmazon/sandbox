package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.alexeyshcheglov.parser.entity.StreetType;

import javax.persistence.NoResultException;

public class StreetTypeDAO implements DAO<StreetType, Integer> {
    private final SessionFactory factory;

    public StreetTypeDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final StreetType streetType) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(streetType);
            session.getTransaction().commit();
        }
    }
    
    @Override
    public StreetType read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final StreetType result = session.get(StreetType.class, id);
            if (result != null) {
                Hibernate.initialize(result.getStreets());
            }
            return result;
        }
    }

    @Override
    public void update(@NotNull final StreetType streetType) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(streetType);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final StreetType streetType) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(streetType);
            session.getTransaction().commit();
        }
    }

    public StreetType getByFullType(String fullType) {
        try (final Session session = factory.openSession()) {
            Query query = session.createQuery("from StreetType where fullType = :field");
            query.setParameter("field", fullType);
            StreetType result = null;
            try {
                result = (StreetType) query.getSingleResult();
            } catch (NoResultException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public StreetType getByShortType(String shortType) {
        try (final Session session = factory.openSession()) {
            Query query = session.createQuery("from StreetType where shortType = :field");
            query.setParameter("field", shortType);
            StreetType result = null;
            try {
                result = (StreetType) query.getSingleResult();
            } catch (NoResultException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}
