package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLadderCreator {
    private static Random RANDOM = new Random();

    public Ladder create(int width, int height) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i -> createRandomLine(width))
                .toList());
    }

    private Line createRandomLine(int width) {
        List<Boolean> scaffolds = new ArrayList<>(Collections.nCopies(width, false));

        for (int index : shuffleOrder(width)) {
            placeRandomScaffold(scaffolds, index);
        }

        return new Line(scaffolds);
    }

    private List<Integer> shuffleOrder(int width) {
        List<Integer> order = new ArrayList<>(IntStream.range(0, width)
                .boxed()
                .toList());
        Collections.shuffle(order);
        return order;
    }

    private void placeRandomScaffold(List<Boolean> scaffolds, int index) {
        if (isLeftExist(scaffolds, index) || isRightExist(scaffolds, index)) {
            return;
        }

        scaffolds.set(index, RANDOM.nextBoolean());
    }

    private boolean isLeftExist(List<Boolean> line, int index) {
        return index - 1 >= 0 && line.get(index - 1);
    }

    private boolean isRightExist(List<Boolean> line, int index) {
        return index + 1 < line.size() && line.get(index + 1);
    }
}
