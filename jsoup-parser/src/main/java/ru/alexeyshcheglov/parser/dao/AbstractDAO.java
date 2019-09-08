package ru.alexeyshcheglov.parser.dao;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import org.hibernate.SessionFactory;

public abstract class AbstractDAO<Entity> {

    @Getter
    private final SessionFactory factory;

    public AbstractDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

//    public Entity getEntityByParameter(String key, String value) {
//        try (final Session session = factory.openSession()) {
//            Query query = session.createQuery("from cities where " + key + " = :parameter");
//            query.setParameter("parameter", value);
//            Entity result = null;
//            try {
//                result = (Entity) query.getSingleResult();
//            } catch (NoResultException e) {
//                e.printStackTrace();
//            }
//            return result;
//        }
//    }
//
//    public Integer getIdByParameter(String parameter) {
//        return getEntityByParameter(parameter).getClass().getField("id");
//    }
}
