public class TextToFile {
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
