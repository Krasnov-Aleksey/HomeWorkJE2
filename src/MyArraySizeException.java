public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Ввели не все данные");
    }
    public MyArraySizeException(String message){
        super(message);
    }
}
