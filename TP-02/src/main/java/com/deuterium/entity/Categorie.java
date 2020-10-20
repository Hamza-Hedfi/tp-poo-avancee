package com.deuterium.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(callSuper = true, exclude = "articles")
public class Categorie extends SuperEntity {

    private List<Article> articles;

    {
        articles = new ArrayList<>();
    }
}
