
//匿名类创建线程
public class CreateThreadWithNimingLei {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("我是子线程");
            }
        });
        t.start();

        while (true) {
            System.out.println("我是 main 线程");
        }
    }
}
