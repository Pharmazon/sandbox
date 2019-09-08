package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexeyshcheglov.parser.entity.City;

public class CityDAO implements DAO<City, Integer> {
    private final SessionFactory factory;

    public CityDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final City city) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
        }
    }

    @Override
    public City read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {
            final City result = session.get(City.class, id);
            if (result != null) {
                Hibernate.initialize(result.getCityType());
            }
            return result;
        }
    }

    @Override
    public void update(@NotNull final City city) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(city);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final City city) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(city);
            session.getTransaction().commit();
        }
    }

//        public City readCityByName(String name) {
//        try (final Session session = factory.openSession()) {
//            Query query = session.createQuery("from City where City.name = :parameter");
//            query.setParameter("parameter", name);
//            City result = null;
//            try {
//                result = (City) query.getSingleResult();
//            } catch (NoResultException e) {
//                e.printStackTrace();
//            }
//            return result;
//        }
//    }
//
//    public Integer readIdByName(String name) {
//        return readCityByName(name).getId();
//    }
}
