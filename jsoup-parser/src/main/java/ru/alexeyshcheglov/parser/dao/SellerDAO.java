package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexeyshcheglov.parser.entity.Seller;

public class SellerDAO implements DAO<Seller, Integer> {
    private final SessionFactory factory;

    public SellerDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final Seller seller) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(seller);
            session.getTransaction().commit();
        }
    }

    @Override
    public Seller read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final Seller result = session.get(Seller.class, id);
            return result != null ? result : new Seller();
        }
    }

    @Override
    public void update(@NotNull final Seller seller) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(seller);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Seller seller) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(seller);
            session.getTransaction().commit();
        }
    }
}
