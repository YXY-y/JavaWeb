
//WhoFirst的结果不固定
//加入就绪队列的时机是确认的，但是神魔时候被调度到CPU是不确定的（随机），什么时候从cpu上调度下来是不确定的（随机）
//为什么看起来是固定的
//我们的任何代码执行的前提，都是该线程拥有CPU
//主线程创建两个线程+打印10次main需要的时间，远远小于时间片
public class WhoFirst {
    static class PrintA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("A");
            }
        }
    }

    static class PrintB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
            }
        }
    }

    public static void main(String[] args) {
        PrintA a = new PrintA();
        PrintB b = new PrintB();
        a.start();
        b.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main");
        }
    }
}
