package Entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Hamza Hadfi
 * @since 2020
 */

public class Article implements Serializable {
    private UUID id;
    private String designation;
    private String description;

    public Article() {
        id = UUID.randomUUID();
    }

    public Article(UUID id, String designation, String description) {
        this.id = id;
        this.designation = designation;
        this.description = description;
    }

    public Article(String designation, String description) {
        id = UUID.randomUUID();
        this.designation = designation;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "Article{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", description='" + description + '\'' +
                '}' + System.lineSeparator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
