public class PhoneCheck {
    public static void phoneCheck(String textPhone){
        try {
            Long numberPhone = Long.parseLong(textPhone);
        } catch (NumberFormatException e){
            throw new NumberFormatException("Вы ввели неверный номер телефона");
        }
    }
}
