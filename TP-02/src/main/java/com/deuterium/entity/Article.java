package com.deuterium.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(callSuper = true)
public class Article extends SuperEntity {
    private Double prix;
    private Depot depot;
    private Integer qte;
    private List<Categorie> categories;

    {
        categories = new ArrayList<>();
        qte = 0;
        prix = 0.0;
    }
}
