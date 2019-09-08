package ru.alexeyshcheglov.parser.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "streets")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"id", "fullType"})
@Entity
@Table(name="street_types")
public class StreetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="full_type")
    @NonNull
    private String fullType;

    @Column(name="short_type")
    @NonNull
    private String shortType;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "streetType")
    private Set<Street> streets = new HashSet<>();
}
