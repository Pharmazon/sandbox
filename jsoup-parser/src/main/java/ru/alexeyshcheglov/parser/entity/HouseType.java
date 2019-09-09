package ru.alexeyshcheglov.parser.entity;

import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HouseType {
    private Integer id;
    private String type;
}
