package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ExtendedBallTest {
    private Game game;
    private TripleBalls computerTripleBalls;
    private TripleBalls userTripleBalls;

    @BeforeEach
    void setUp() {
        game = new Game();
        computerTripleBalls = new TripleBalls(Arrays.asList(new Ball(1, 1),
                new Ball(2, 2), new Ball(3, 3)));
    }

    @Test
    void Ball_3개인_경우_3스트라이크() {
        userTripleBalls = new TripleBalls(Arrays.asList(new Ball(1, 1),
                new Ball(2, 2), new Ball(3, 3)));

        String gameResult = game.checkTripleBalls(computerTripleBalls, userTripleBalls);
        Assertions.assertThat(gameResult).isEqualTo("3스트라이크");
    }

    @Test
    void Ball_3개인_경우_1볼_2스트라이크() {
        userTripleBalls = new TripleBalls(Arrays.asList(new Ball(4, 1),
                new Ball(2, 2), new Ball(3, 3)));

        String gameResult = game.checkTripleBalls(computerTripleBalls, userTripleBalls);
        Assertions.assertThat(gameResult).isEqualTo("1볼2스트라이크");
    }

    @Test
    void Ball_3개인_경우_2볼_1스트라이크() {
        userTripleBalls = new TripleBalls(Arrays.asList(new Ball(1, 1),
                new Ball(5, 2), new Ball(5, 3)));

        String gameResult = game.checkTripleBalls(computerTripleBalls, userTripleBalls);
        Assertions.assertThat(gameResult).isEqualTo("2볼1스트라이크");
    }

    @Test
    void Ball_3개인_경우_3볼() {
        userTripleBalls = new TripleBalls(Arrays.asList(new Ball(4, 1),
                new Ball(5, 2), new Ball(6, 3)));

        String gameResult = game.checkTripleBalls(computerTripleBalls, userTripleBalls);
        Assertions.assertThat(gameResult).isEqualTo("3볼");
    }

    @Test
    void Ball_3개인_경우_1볼() {
        userTripleBalls = new TripleBalls(Arrays.asList(new Ball(3, 1),
                new Ball(2, 6), new Ball(3, 9)));

        String gameResult = game.checkTripleBalls(computerTripleBalls, userTripleBalls);
        Assertions.assertThat(gameResult).isEqualTo("1볼");
    }



}
