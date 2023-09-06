import java.util.Scanner;

public class DataInput {
    public static String[] dataInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Фамилия Имя Отчество, дата_рождения формата dd.mm.yyyy, " +
                "номер телефона, пол f или m (через пробел)");
        String text = scanner.nextLine();
        String [] textArr = text.split(" ");
        if (textArr.length>6){
            throw new MyArraySizeException("Вы ввели больше данных чем требуется");
        }
        if (textArr.length<6){
            throw new MyArraySizeException("Вы ввели меньше данных чем требуется");
        }
        return textArr;
    }
}
