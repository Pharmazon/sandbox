package ru.alexeyshcheglov.parser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Address {
    private Integer id;
    private Region region;
    private City city;
    private District district;
    private Street street;
    private Integer houseNumber;

    @Override
    public String toString() {
        return district == null ? region.toString() + ", " + city.toString() + ", " +
                street.toString() + ", " + houseNumber :
                    region.toString() + ", " + city.toString() + ", " + district.toString() + ", " +
                    street.toString() + ", " + houseNumber;
    }
}
