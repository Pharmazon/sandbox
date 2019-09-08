package ru.alexeyshcheglov.parser.entity;

import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    private Integer id;
    private String contact;
}
