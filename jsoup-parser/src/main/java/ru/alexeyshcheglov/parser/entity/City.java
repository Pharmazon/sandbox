package ru.alexeyshcheglov.parser.entity;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "cities")
public class City extends Model {

    private static final long serialVersionUID = -3354247160847843625L;
    
    @Column(name = "name", length = 50, nullable = false)
    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_type_id", nullable = false)
    private CityType cityType;
}
