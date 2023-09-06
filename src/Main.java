import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
//    Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
//    разделенные пробелом: Фамилия Имя Отчество, дата_рождения, номер телефона, пол
//    Форматы данных:фамилия, имя, отчество - строки
//    дата_рождения- строка формата dd.mm.yyyy
//    номер_телефона - целое беззнаковое число без форматирования
//    пол - символ латиницей f или m.
//    Критерии:
//             Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
//    вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше
//    данных, чем требуется.
//             Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
//    Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно
//    использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
//    пользователю выведено сообщение с информацией, что именно неверно.
//             Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
//            в него в одну строку должны записаться полученные данные, вида.
//    <Фамилия><Имя><Отчество><дата рождения> <номер телефона><пол>
//
//    Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//
//    Не забудьте закрыть соединение с файлом.
//
//    При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
//    пользователь должен увидеть стектрейс ошибки.
public class Main {

    public static void main(String[] args) {
        String [] textArr = dataInput();
        System.out.println(Arrays.toString(textArr));
        // TODO textArr[3]
        dateCheck(textArr[3]);
        phoneCheck(textArr[4]);
        genderCheck(textArr[5]);
        saveFile(textArr[0],textToFile(textArr));
    }

    public static String[] dataInput(){
        //TODO включить сканер
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Фамилия Имя Отчество, дата_рождения формата dd.mm.yyyy, " +
                "номер телефона, пол f или m (через пробел)");
        //String string = scanner.nextLine();
        // TODO удалить
        String text = "Краснов Алексей Евгеньевич 23.08.1980 89200723170 m";
        String [] textArr = text.split(" ");
        if (textArr.length>6){
            throw new MyArraySizeException("Вы ввели больше данных чем требуется");
        }
        if (textArr.length<6){
            throw new MyArraySizeException("Вы ввели меньше данных чем требуется");
        }
        return textArr;
    }
    public static void dateCheck(String textData){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date = dateFormat.parse(textData);
            String strDate = dateFormat.format(date);
            // TODO дата рождение больше текущей
            if (!textData.equals(strDate)){
                // TODO MyArraySizeException
                throw new RuntimeException();
            }
        } catch (ParseException | RuntimeException e) {
            throw new RuntimeException("Вы ввели неверную дату");
        }

    }
    public static void phoneCheck(String textPhone){
        try {
            Long numberPhone = Long.parseLong(textPhone);
        } catch (NumberFormatException e){
            throw new NumberFormatException("Вы ввели неверный номер телефона");
        }
    }
    public static void genderCheck(String gender){
        if (!gender.equals("f") && !gender.equals("m")){
            throw new RuntimeException("Неправильно введен пол");
        }
    }
    public static void saveFile(String path, String text){
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String textToFile(String[] textArr){
        StringBuilder stringBuilder = new StringBuilder();
        for (String text: textArr) {
            stringBuilder.append("<");
            stringBuilder.append(text);
            stringBuilder.append(">");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}