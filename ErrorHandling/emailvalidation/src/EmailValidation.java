import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EmailValidation {

    public static void main(String[] args) {

        List<String> emails = new ArrayList<>();
        emails.add("user@domain.com");
        emails.add("user@domain.co.in");
        emails.add("user.name@domain.com");
        emails.add("user?name@domain.co.in");
        emails.add("user'name@domain.co.in");
        //Invalid emails
        emails.add("@yahoo.com");

        emailValidation(emails);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static boolean emailValidation(List<String> emailsForCheck) throws PatternSyntaxException {

        try {
            String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
            /*Pattern object is a compiled representation of a regular expression.
            compile() will return a Pattern object*/
            Pattern pattern = Pattern.compile(regex);

            for (String email : emailsForCheck) {
                Matcher matcher = pattern.matcher(email);
                System.out.println(email + " : " + matcher.matches());
            }
            //syntax error
        } catch (PatternSyntaxException ex) {
            throw ex;
        }
        return false;
    }
}
