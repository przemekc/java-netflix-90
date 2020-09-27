package pl.yellowduck.netflix90.resources;


import org.junit.Test;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.films.*;

import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoCassetteCatalogTest {


    // test sprawdza czy utworzony katalog jest wyjsciowo pusty
    @Test
    public void shouldCreateCatalogThatIsEmpty() {
        // when
        IVideoCassetteCatalog catalog = new VideoCassetteCatalog();
        // then
        assertThat(catalog.getAll()).isEmpty();
    }

    @Test // org.junit.Test
    public void shouldAddVideoCassetteToCatalog() throws CatalogAddException {
        // given
        IVideoCassetteCatalog catalog = new VideoCassetteCatalog();
        Category category = new Category("DRAMA", "Dramat");
        VideoCassette videoCassette = new VideoCassette(
                "V001",
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
//                Category.DRAMA,
                category,
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));

        // when
        catalog.add(videoCassette);

        // then
        assertThat(catalog.getAll())
                .hasSize(1);
    }

    @Test // org.junit.Test
    public void shouldAddVideoCassettesToCatalog() throws CatalogAddException {
        // given
        Category category = new Category("DRAMA", "Dramat");
        IVideoCassetteCatalog catalog = new VideoCassetteCatalog();
        VideoCassette videoCassette1 = new VideoCassette(
                "V001",
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
//                Category.DRAMA,
                category,
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));

        VideoCassette videoCassette2 = new VideoCassette(
                "V002",
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
//                Category.DRAMA,
                category,
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));

        // when
        // mozna tak ale lepiej udostepnic metode do zlozonej operacji
//        for (VideoCassette cassette : List.of(videoCassette1, videoCassette2)) {
//            catalog.addVideoCassette(cassette);
//        }
        catalog.addAll(videoCassette1, videoCassette2);

        // then
        assertThat(catalog.getAll())
                .hasSize(2);
    }
}
