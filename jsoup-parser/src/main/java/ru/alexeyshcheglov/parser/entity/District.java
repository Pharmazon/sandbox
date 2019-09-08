package ru.alexeyshcheglov.parser.entity;

import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class District {

    private Integer id;

    @NonNull
    private String name;

    private DistrictType districtType;
}
