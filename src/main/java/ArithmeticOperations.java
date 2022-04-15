public class ArithmeticOperations {

        public static void main(String[] args) {
            int a = doSum(2, 2);
            int b = doDeduction(11, 14);
            int c = doMultiplication(10, 5);
            int d = doDivision(10, 5);
            int e = doBalanceFromDivision(10, 3);
            int f = 999999998;
            String string = "Это строка для теста";
            System.out.println(string + " " + a); // сложение строки с целым числом

            //System.out.println(f + 1000000000000); // переполнение, ошибка
            //System.out.println (f - 100000000000);// переполнение, ошибка
        /*char aChar = "Ω";
        System.out.println(aChar + " " + string + " " + aLong); // сложение символа , строки и типа long - выдает ошибку*/

            if (a == b) {
                System.out.println(++a);
            } else System.out.println(a++);

            if (c != d) {
                System.out.println(--c);
            } else System.out.println(c--);

            if (e > 1) {
                System.out.println("true");
            } else System.out.println("false");

            if (e <= 1 && e >= b) {
                System.out.println("true");
            }

            if (a > 0 || c > 0) {
                System.out.println("true");
            }
        }

        public static int doSum(int x, int y) {
            return x + y;
        }

        public static int doDeduction(int x, int y) {
            return x - y;
        }

        public static int doMultiplication(int x, int y) {
            return x * y;
        }

        public static int doDivision(int x, int y) {
            return x / y;
        }

        public static int doBalanceFromDivision(int x, int y) {
            return x % y;
        }
    }

