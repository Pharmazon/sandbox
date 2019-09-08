package ru.alexeyshcheglov.parser.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "city_types")
public class CityType extends Model {

    private static final long serialVersionUID = -8608199797332415337L;

    @Column(name = "full_type", length = 20, nullable = false)
    @NonNull
    private String fullType;

    @Column(name = "short_type", length = 10, nullable = false)
    @NonNull
    private String shortType;

    @OneToMany(mappedBy = "cityType")
    private Set<City> cities;
}
