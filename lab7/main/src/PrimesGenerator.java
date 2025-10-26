import java.util.*;

class PrimesGenerator implements Iterable<Integer> {
    private final int count;

    public PrimesGenerator(int N) {
        this.count = N;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int generated = 0;
            private int current = 2;

            @Override
            public boolean hasNext() {
                return generated < count;
            }

            @Override
            public Integer next() {
                while (true) {
                    if (isPrime(current)) {
                        generated++;
                        int prime = current;
                        current++;
                        return prime;
                    }
                    current++;
                }
            }

            private boolean isPrime(int n) {
                if (n < 2) return false;
                if (n == 2) return true;
                if (n % 2 == 0) return false;
                for (int i = 3; i * i <= n; i += 2) {
                    if (n % i == 0) return false;
                }
                return true;
            }
        };
    }
}

class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10;
        PrimesGenerator generator = new PrimesGenerator(N);

        List<Integer> primes = new ArrayList<>();
        for (int prime : generator) {
            primes.add(prime);
        }

        System.out.println("Прямой порядок: " + primes);

        Collections.reverse(primes);
        System.out.println("Обратный порядок: " + primes);
    }
}