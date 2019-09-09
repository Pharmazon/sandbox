package ru.alexeyshcheglov.parser.entity;

import lombok.*;

import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "districts")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "districts")
public class DistrictType {

    private Integer id;

    @NonNull
    private String fullType;

    @NonNull
    private String shortType;

    private Set<District> districts;
}
