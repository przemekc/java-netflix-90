package pl.yellowduck.netflix90.resources;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoCassetteCatalogTest {


    // test sprawdza czy utworzony katalog jest wyjsciowo pusty
    @Test
    public void shouldCreateCatalogThatIsEmpty() {
        // when
        IVideoCassetteCatalog catalog = new VideoCassetteCatalog();
        // then
        assertThat(catalog.getVideoCassettes()).isEmpty();
    }

    @Test // org.junit.Test
    public void shouldAddVideoCassetteToCatalog() {
        // given
        IVideoCassetteCatalog catalog = new VideoCassetteCatalog();
        VideoCassette videoCassette = new VideoCassette(
                "V001",
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
                Category.DRAMA,
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));

        // when
        catalog.addVideoCassette(videoCassette);

        // then
        assertThat(catalog.getVideoCassettes())
                .hasSize(1);
    }

    @Test // org.junit.Test
    public void shouldAddVideoCassettesToCatalog() {
        // given
        IVideoCassetteCatalog catalog = new VideoCassetteCatalog();
        VideoCassette videoCassette1 = new VideoCassette(
                "V001",
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
                Category.DRAMA,
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));

        VideoCassette videoCassette2 = new VideoCassette(
                "V002",
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
                Category.DRAMA,
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));

        // when
        // mozna tak ale lepiej udostepnic metode do zlozonej operacji
//        for (VideoCassette cassette : List.of(videoCassette1, videoCassette2)) {
//            catalog.addVideoCassette(cassette);
//        }
        catalog.addVideoCassette(videoCassette1, videoCassette2);

        // then
        assertThat(catalog.getVideoCassettes())
                .hasSize(2);
    }
}
