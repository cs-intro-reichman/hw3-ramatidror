    public class Algebra {
        public static void main(String[] args) {
            System.out.println("givven checks");
            System.out.println(plus(2,3));   // 2 + 3
            System.out.println(minus(7,2));  // 7 - 2
            System.out.println(minus(2,7));  // 2 - 7
            System.out.println(times(3,4));  // 3 * 4
            System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
            System.out.println(pow(5,3));      // 5^3
            System.out.println(pow(3,5));      // 3^5
            System.out.println(div(12,3));   // 12 / 3
            System.out.println(div(5,5));    // 5 / 5
            System.out.println(div(25,7));   // 25 / 7
            System.out.println(mod(25,7));   // 25 % 7
            System.out.println(mod(120,6));  // 120 % 6
            System.out.println(sqrt(36));// sqrt 36 = 6
            System.out.println(sqrt(263169));
            System.out.println(sqrt(76123));

            System.out.println("plus checks");
            System.out.println(plus(-1, -1));
            System.out.println(plus(11, 1));
            System.out.println(plus(-1, 1));
            System.out.println(plus(1, -1));

            System.out.println("minus checks");
            System.out.println(minus(5, 2));
            System.out.println(minus(5, 10));
            System.out.println(minus(-5, -2));
            System.out.println(minus(-5, -6));
            System.out.println(minus(5, -2));
            System.out.println(minus(5, 2));

            System.out.println("times checks");
            System.out.println(times(5, 2));
            System.out.println(times(5, -2));
            System.out.println(times(5, 0));
            System.out.println(times(-5, -2));
            System.out.println(times(-5, 2));

            System.out.println("pow checks");
            System.out.println(pow(5, 0));
            System.out.println(pow(4, 2));
            System.out.println(pow(-4, 2));
            System.out.println(pow(-4, 3));
            System.out.println(pow(4, -2));
            System.out.println(pow(-4, -2));

            System.out.println("division checks");
            System.out.println(div(600, 2));
            System.out.println(div(600, -2));
            System.out.println(div(-600, -2));
            System.out.println(div(-600, 2));
            System.out.println(div(-600, 0));
            System.out.println(div(600, 0));

            System.out.println("modulo checks");
            System.out.println(mod(-132, 100));
            System.out.println(mod(132, 100));
            System.out.println(mod(132, 132));

            System.out.println("sqrt checks");
            System.out.println(sqrt(100));
            System.out.println(sqrt(110));
            System.out.println(sqrt(-100));

            System.out.println("possitiveValue checks");
            System.out.println(possitiveValue(25));
            System.out.println(possitiveValue(0));
            System.out.println(possitiveValue(-25));
        }

        public static int plus(int a, int b) {
            int sum = 0;
            if (b >= 0) {
                for (int i = 0; i <= b; i++) {
                    sum = a++;
                }
            }
            else if (b < 0) {
                for (int i = 0; i >= b; i--) {
                    sum = a--;
                }
            }
            return sum;
        }

        public static int minus(int a, int b) {
            int difference = 0;
            if (b >= 0) {
                for (int i = 0; i <= b; i++) {
                    difference = a--;
                }
            }
            else if (b < 0) {
                for (int i = 0; i >= b; i--) {
                    difference = a++;
                }
            }
            return difference;
        }

        public static int times(int a, int b) {
            int product = 0;
            if (b > 0) {
                for (int i = 0; i < b; i++) {
                    product = plus(product, a);
                }
            }
            else if (b < 0) {
                for (int i = 0; i > b; i--) {
                    product = minus(product, a);
                }
            }
            else {
                product = 0;
            }

            return product;
        }

        public static int pow (int a, int b) {
            int powResult = a;
            if (b > 0) {
                for (int i = 0; i < minus(b, 1); i++) {
                    powResult = times(powResult, a);
                }
            }
            else if (b < 0) {
                int negativePow = a;
                    for (int i = 0; i < minus(b, 1); i++) {
                        negativePow = times(powResult, a);
                }
                powResult = div(1, negativePow);
            }
            else {
                powResult = 1;
            }
            return powResult;
        }

        public static int possitiveValue(int a) {
            if (a > 0) {
                a = a;
            }
            else {
                a = minus(0, a);

            }
            return a;
        }


        public static int div(int a, int divisor) {
            int quotient = 0;
            if (divisor == 0) {
                System.out.println (" ERROR");
            }
            else if ((divisor > 0) && (a > 0)) {
                for (int i = 0; plus((times(divisor, i)), divisor) <= a; i++) {
                    quotient++;
                }
            }
            else if ((divisor > 0) && (a < 0)) {
                a = possitiveValue(a);
                for (int i = 0; plus((times(divisor, i)), divisor) <= a; i++) {
                    quotient++;
                }
                quotient = minus(0, quotient);
            }
            else if ((divisor < 0) && (a > 0)) {
                divisor = possitiveValue(divisor);
                for (int i = 0; plus((times(divisor, i)), divisor) <= a; i++) {
                    quotient++;
                }
                quotient = minus(0, quotient);
            }
            else if ((divisor < 0) && (a < 0)) {
                divisor = possitiveValue(divisor);
                a = possitiveValue(a);
                for (int i = 0; plus((times(divisor, i)), divisor) <= a; i++) {
                    quotient++;
                }
            }
                return quotient;
        }

        public static int mod(int a, int b) {
            int remainder = minus(a, times(b, (div(a, b))));
            return remainder;
        }

        public static int sqrt(int a) {
            int root = 0;
                if (a >= 0) {
                    while ((pow(root, 2)) <= a) {
                    root++;
                    if (pow(root, 2) >= a) {
                    break;
                        }
                    }
                    if ((pow (root,2)) > a) {
                        root = minus (root, 1);
                }
            }
                else {
                    System.out.println (" ERROR");
                }
            return root;
        }
    }

