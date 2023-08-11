package lexicon.sequencer;

public class PersonIdGenerator {
    private static Integer idNumberCounter = 0;

    public static Integer generateNextIdNumber() {
        return ++idNumberCounter;
    }
}