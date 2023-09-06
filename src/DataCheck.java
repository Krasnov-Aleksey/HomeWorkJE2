import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataCheck {
    public static void dateCheck(String textData) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date dateNow = new Date();
        try {
            Date date = dateFormat.parse(textData);
            String strDate = dateFormat.format(date);
            if (!textData.equals(strDate) || (date.after(dateNow))){
                throw new RuntimeException();
            }
        } catch (ParseException | RuntimeException e) {
            throw new RuntimeException("Вы ввели неверную дату");
        }
    }
}
