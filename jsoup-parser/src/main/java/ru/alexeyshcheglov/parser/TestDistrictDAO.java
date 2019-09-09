package ru.alexeyshcheglov.parser;

import org.hibernate.SessionFactory;
import ru.alexeyshcheglov.parser.dao.DAO;
import ru.alexeyshcheglov.parser.dao.DistrictDAO;
import ru.alexeyshcheglov.parser.entity.District;
import ru.alexeyshcheglov.parser.entity.DistrictType;
import ru.alexeyshcheglov.parser.util.HibernateUtil;

public class TestDAO {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        try {
            DAO<District, Integer> dao = new DistrictDAO(factory);
            District district = new District("Комсомольский");
            DistrictType districtType = new DistrictType("район", "р-н");
            district.setDistrictType(districtType);
            System.out.println(district);
            dao.create(district);

            District dist = dao.read(1);
            System.out.println(dist);


        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}
