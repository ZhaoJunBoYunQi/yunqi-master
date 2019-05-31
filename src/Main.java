public class Main {


    public static int i = 0;
    public volatile static boolean flag = false;
    public static void  write() {
        i = 5;
        flag = true;
        System.out.println(Thread.currentThread().getName()+":线程写: " + flag + " :" +i);

    }
    public static void  read() {
        if (flag){
            int a = i + 1;
            System.out.println(a);
        }

        System.out.println(Thread.currentThread().getName()+":线程读: " + flag + " :" +i);

    }

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                write();
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                read();
            }
        }.start();
    }

    private static class ss{}


}
