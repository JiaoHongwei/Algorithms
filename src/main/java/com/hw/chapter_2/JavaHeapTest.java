package com.hw.chapter_2;

/**
 * @Description TODO
 * @Author hw
 * @Date 2019/1/23 15:47
 * @Version 1.0
 */
public class JavaHeapTest {

    public final static int OUTMEMEORY = 200000000;
    private String oom;
    private int length;

    StringBuffer tempOOM = new StringBuffer();

    public JavaHeapTest(int leng) {
        this.length = leng;
        int i = 0;
        while (i < leng) {
            try {
//                Thread.sleep(1000);
                tempOOM.append("a");
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        this.oom = tempOOM.toString();


    }

    public String getOom() {
        return oom;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        JavaHeapTest javaHeapTest = new JavaHeapTest(OUTMEMEORY);
        System.out.println(javaHeapTest.getOom().length());
    }

}
