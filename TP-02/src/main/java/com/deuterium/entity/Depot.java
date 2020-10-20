package com.deuterium.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Depot extends SuperEntity {
    private List<Article> articles;

    {
        articles = new ArrayList<>();
    }
}
