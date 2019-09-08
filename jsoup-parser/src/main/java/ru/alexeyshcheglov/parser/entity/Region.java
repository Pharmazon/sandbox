package ru.alexeyshcheglov.parser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    private Integer id;
    private String name;

    public Region(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
