package ladder.domain;

public enum Command {
    ALL_RESULT("all");

    private final String text;

    Command(String text) {
        this.text = text;
    }

    public boolean isCommand(String text) {
        return this.text.equals(text);
    }
}