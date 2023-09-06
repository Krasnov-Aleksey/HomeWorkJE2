public class GenderCheck {
    public static void genderCheck(String gender){
        if (!gender.equals("f") && !gender.equals("m")){
            throw new RuntimeException("Неправильно введен пол");
        }
    }
}
