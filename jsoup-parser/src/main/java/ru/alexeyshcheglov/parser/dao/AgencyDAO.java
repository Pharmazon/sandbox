package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexeyshcheglov.parser.entity.Agency;

public class AgencyDAO implements DAO<Agency, Integer> {
    private final SessionFactory factory;

    public AgencyDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final Agency agency) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(agency);
            session.getTransaction().commit();
        }
    }

    @Override
    public Agency read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final Agency result = session.get(Agency.class, id);
            return result != null ? result : new Agency();
        }
    }

    @Override
    public void update(@NotNull final Agency agency) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(agency);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Agency agency) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(agency);
            session.getTransaction().commit();
        }
    }
}