package pl.yellowduck.netflix90.resources;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoCassetteTest {

    @Test
    public void shouldVideoCassetteIsEqual() {
        // given
        VideoCassette videoCassette1 = new VideoCassette(
                "V001",
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
                Category.DRAMA,
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));

        VideoCassette videoCassette2 = new VideoCassette(
                "V001",
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
                Category.DRAMA,
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));
        // when
        boolean result = videoCassette1.equals(videoCassette2);
        // then
        assertThat(result).isTrue();
        assertThat(videoCassette1.hashCode()).isEqualTo(videoCassette2.hashCode());
    }
}
