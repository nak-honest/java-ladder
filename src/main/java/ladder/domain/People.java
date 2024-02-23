package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static ladder.constant.ErrorMessage.MIN_PEOPLE_COUNT;

public class People {
    private static final int MIN_COUNT = 2;

    private final List<Person> values;

    public People(List<Person> values) {
        this.values = new ArrayList<>(values);
        validateCount(this.values);
    }

    private static void validateCount(List<Person> values) {
        if (values.size() < MIN_COUNT) {
            throw new IllegalArgumentException(MIN_PEOPLE_COUNT.generate());
        }
    }

    public int getCount() {
        return values.size();
    }

    public List<String> getNames() {
        return values.stream()
                .map(Person::getName)
                .toList();
    }
}
