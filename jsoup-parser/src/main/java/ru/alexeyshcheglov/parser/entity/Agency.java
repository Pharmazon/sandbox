package ru.alexeyshcheglov.parser.entity;

import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Agency {
    private Integer id;
    private String name;
}
