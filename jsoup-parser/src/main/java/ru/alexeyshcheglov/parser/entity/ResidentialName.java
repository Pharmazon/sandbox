package ru.alexeyshcheglov.parser.entity;

import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResidentialName {
    private Integer id;
    private String name;
}
