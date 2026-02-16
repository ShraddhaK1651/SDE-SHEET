You are given:String S
Multiple queries (each query = string T)
For each query T:
Consider all suffixes of S
Among suffixes that start with T
Pick the lexicographically smallest suffix.Return its length
If none → return 0
Finally return sum of all query answers % (10⁹+7)

  SOLUTION:
  
import java.util.*;
public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();      // size of string
        int Q = sc.nextInt();      // number of queries
        sc.nextLine();

        String S = sc.nextLine();

        // Generate all suffixes
        List<String> suffixes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            suffixes.add(S.substring(i));
        }

        // Sort lexicographically
        Collections.sort(suffixes);

        long total = 0;

        while (Q-- > 0) {
            String T = sc.nextLine();

            int length = 0;

            for (String suf : suffixes) {
                if (suf.startsWith(T)) {
                    length = suf.length();
                    break; // first lexicographically smallest
                }
            }

            total = (total + length) % MOD;
        }

        System.out.println(total);
    }
}
