package pl.yellowduck.netflix90.films;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "films")
public class VideoCassette {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private BigDecimal price;
    @Getter
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_d")
    private Director director;

    //  @ManyToOne(fetch = FetchType.LAZY)
    @Transient
    private Category category;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Actor> actors;


    public void printOut() {
        // print casette data with below pattern
        //    | ID | Title | Category | Price | Director | Actors |
        StringBuilder builder = new StringBuilder();
        builder.append("|")
                .append(this.id)
                .append("|")
                .append(this.title)
                .append("|")
                .append(this.category)
                .append("|")
                .append(this.price)
                .append("|")
                .append(this.director.toString())
                .append("|")
                .append(this.actors)
                .append("|");
        System.out.println(builder.toString());
    }

    private Set<Actor> getActors() {
        return actors;
    }

    private void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public void add(Actor actor) {
        if (getActors() == null) {
            setActors(new HashSet<>());
        }
        getActors().add(actor);
    }

    @Transient
    public Set<Actor> getActorsCollection() {
        if (getActors() == null) {
            setActors(new HashSet<>());
        }
        return Collections.unmodifiableSet(getActors());
    }

    public static VideoCassetteBuilder builder() {
        return new VideoCassetteBuilder();
    }

    public static final class VideoCassetteBuilder {
        private Integer id;
        private BigDecimal price;
        private String title;
        private Director director;
        private Category category;
        private Set<Actor> actors;

        private VideoCassetteBuilder() {
        }

        public VideoCassetteBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public VideoCassetteBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public VideoCassetteBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public VideoCassetteBuilder withDirector(Director director) {
            this.director = director;
            return this;
        }

        public VideoCassetteBuilder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public VideoCassetteBuilder withActors(Set<Actor> actors) {
            this.actors = actors;
            return this;
        }

        public VideoCassette build() {
            VideoCassette videoCassette = new VideoCassette();
            videoCassette.id = this.id;
            videoCassette.actors = this.actors;
            videoCassette.price = this.price;
            videoCassette.category = this.category;
            videoCassette.director = this.director;
            videoCassette.title = this.title;
            return videoCassette;
        }
    }
}
