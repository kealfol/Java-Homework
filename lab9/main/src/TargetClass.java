public class TargetClass {

    public void publicMethod1(String msg) {
        System.out.println("Публичный метод 1: " + msg);
    }

    @MyAnnotation(2)
    public void publicMethod2(int number) {
        System.out.println("Публичный метод 2: число = " + number);
    }

    @MyAnnotation(3)
    protected void protectedMethod1(double d) {
        System.out.println("Защищённый метод 1: double = " + d);
    }

    @MyAnnotation(1)
    protected void protectedMethod2(String s) {
        System.out.println("Защищённый метод 2: строка = " + s);
    }

    @MyAnnotation(4)
    private void privateMethod1(boolean flag) {
        System.out.println("Приватный метод 1: флаг = " + flag);
    }

    @MyAnnotation(0)
    private void privateMethod2(char c) {
        System.out.println("Приватный метод 2: символ = " + c);
    }
}