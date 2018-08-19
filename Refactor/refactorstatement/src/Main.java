public class Main {
    public static void main(String[] args) {

        GuessMessage message = new GuessMessage();
        System.out.println(message.makeSentenceWithSingleWordAndCount("movie", 10));

        GuessMessage message2 = new GuessMessage();
        System.out.println(message2.makeSentenceWithSingleWordAndCount("movie", 0));

        GuessMessage message3 = new GuessMessage();
        System.out.println(message3.makeSentenceWithSingleWordAndCount("movie", 1));
    }
}
