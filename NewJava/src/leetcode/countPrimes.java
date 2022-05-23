package leetcode;

import java.util.ArrayList;
import java.util.List;

public class countPrimes {
    public int countPrimes(int n) {
        // false表示为素数，true则为和数
        boolean[] ret = new boolean[n];
        List<Integer> prime = new ArrayList<>();
        int index = 0;
        for (int i = 2; i < n; i++) {
            // 将素数加入prime
            if (ret[i] == false) {
                prime.add(i);
            }
            // 每个数与素数的乘积均为和数
            for (int j = 0; j < prime.size() && i * prime.get(j) < n; j++) {
                ret[i * prime.get(j)] = true;
                if (i % prime.get(j) == 0) {
                    break;
                }
            }
        }
        return prime.size();
    }
}
