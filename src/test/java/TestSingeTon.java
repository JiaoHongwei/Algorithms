import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/11 17:22
 * @Version 1.0
 */
public class TestSingeTon {
    private static CountDownLatch countDownLatch = new CountDownLatch(10000);

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SingleTon singleTon = SingleTon.getInstance();

                }
            }).start();
            countDownLatch.countDown();
        }
        System.out.println("完成");

    }
}
