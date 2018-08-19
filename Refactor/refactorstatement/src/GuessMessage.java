//After refactoring
public class GuessMessage {

    private String number;
    private String verb;
    private String pluralModifier;

    public GuessMessage() {
    }

    public String makeSentenceWithSingleWordAndCount(String singleWord, int count) {
        createPluralDependentMessageParts(count);
        return String.format(
                "There %s %s %s%s", verb, number, singleWord, pluralModifier);
    }

    private void createPluralDependentMessageParts(int count) {
        if (count == 0) {
            thereAreNoLetters();
        } else if (count == 1) {
            thereIsOneLetter();
        } else {
            thereAreManyLetters(count);
        }
    }

    private void thereAreManyLetters(int count) {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s.";
    }

    private void thereIsOneLetter() {
        number = "1";
        verb = "is";
        pluralModifier = ".";
    }

    private void thereAreNoLetters() {
        number = "no";
        verb = "are";
        pluralModifier = "s.";
    }
}

