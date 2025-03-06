package ex02;

public class TextResultDisplay implements ResultDisplay {
    @Override
    public void display(ResultData data) {
        System.out.println(data + "\n");
    }
}