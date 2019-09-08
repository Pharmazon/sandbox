package ru.alexeyshcheglov.parser.dao;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.alexeyshcheglov.parser.entity.District;
import ru.alexeyshcheglov.parser.entity.DistrictType;
import ru.alexeyshcheglov.parser.util.HibernateUtil;

public class DistrictDAOTest {

    private SessionFactory factory;

    private DAO<District, Integer> dao;

    @Before
    public void connect() {
        this.factory = HibernateUtil.getSessionFactory();
        this.dao = new DistrictDAO(factory);
    }

    @Test
    public void test1() {
        District expected = new District("zzzzzzzzzz");
        DistrictType districtType = new DistrictType("bbbbb", "b-b");
        expected.setDistrictType(districtType);
        dao.create(expected);

        District actual = dao.read(1);
        Assert.assertEquals(actual, expected);
    }

    @After
    public void disconnect() {
        factory.close();
    }
}
