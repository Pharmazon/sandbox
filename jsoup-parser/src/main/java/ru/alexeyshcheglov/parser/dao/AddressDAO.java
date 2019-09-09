package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexeyshcheglov.parser.entity.Address;

public class AddressDAO implements DAO<Address, Integer> {
    private final SessionFactory factory;

    public AddressDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final Address address) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        }
    }

    @Override
    public Address read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final Address result = session.get(Address.class, id);
            if (result != null) {
                Hibernate.initialize(result.getCity());
                Hibernate.initialize(result.getDistrict());
                Hibernate.initialize(result.getRegion());
                Hibernate.initialize(result.getStreet());
            }
            return result;
        }
    }

    @Override
    public void update(@NotNull final Address address) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(address);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Address address) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(address);
            session.getTransaction().commit();
        }
    }
}
