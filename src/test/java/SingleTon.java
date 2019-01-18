/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/10 16:27
 * @Version 1.0
 */
public class SingleTon {
    private static  SingleTon singleTon;

    private SingleTon() {
        System.out.println("SingleTon init...");
    }

    public static SingleTon getInstance() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
