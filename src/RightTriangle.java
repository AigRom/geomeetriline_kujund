import java.util.Random;
import java.util.Scanner;

public class RightTriangle {

    // Klass arvutuste jaoks
    static class CalculateTriangle {
        double a; // Arvutatud külg
        double b; // Juhuslik külg
        double c; // Hüpotenuus (kasutajalt)

        public CalculateTriangle(double b, double c) {
            this.b = b;
            this.c = c;
            this.a = Math.sqrt(c * c - b * b); // Arvutame a Pythagorase teoreemiga
        }

        // Arvutab pindala
        public double calculateArea() {
            return (a * b) / 2;
        }

        // Arvutab ümbermõõdu
        public double calculatePerimeter() {
            return a + b + c;
        }

        // Arvutab nurga α (külje a vastas) kraadides
        public double calculateAngleAlpha() {
            return Math.toDegrees(Math.asin(a / c));
        }

        // Arvutab nurga β (külje b vastas) kraadides
        public double calculateAngleBeta() {
            return Math.toDegrees(Math.asin(b / c));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        try {
            // Küsime hüpotenuusi c
            System.out.print("Sisesta täisnurkse kolmnurga hüpotenuus c (murdarv): ");
            double c = Double.parseDouble(scanner.nextLine());

            if (c <= 0) {
                System.out.println("Hüpotenuus peab olema positiivne arv!");
                return;
            }

            // Genereerime külje b (juhuslik arv < c, kuni 3 kohta peale koma)
            double b;
            do {
                int randomInt = 1 + random.nextInt((int) ((c - 0.001) * 1000));
                b = randomInt / 1000.0;
            } while (b >= c);

            // Loome kolmnurga ja teeme arvutused
            CalculateTriangle triangle = new CalculateTriangle(b, c);

            double a = triangle.a;
            double area = triangle.calculateArea();
            double perimeter = triangle.calculatePerimeter();
            double angleAlpha = triangle.calculateAngleAlpha();
            double angleBeta = triangle.calculateAngleBeta();

            // Väljastame tulemused
            System.out.println("Täisnurkse kolmnurga hüpotenuusiga " + c +
                    " ja küljega " + b + "\n" +
                    " külg a = " + a +
                    ", pindala = " + area +
                    ", ümbermõõt = " + perimeter + "\n" +
                    ", nurk α = " + angleAlpha + " kraadi ja nurk β = " + angleBeta + " kraadi.");

        } catch (NumberFormatException e) {
            System.out.println("Palun sisesta korrektne murdarv!");
        }
    }
}
