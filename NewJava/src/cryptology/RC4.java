package cryptology;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RC4 {
    public List<Integer> RC4(int len, int[] k, int lenM) {
        // S为状态向量， T为临时密钥向量
        int[] S = new int[len];
        int[] T = new int[len];
        int keyLen = k.length;
        // 初始化S T
        for (int i = 0; i < len; i++) {
            S[i] = i;
            T[i] = k[i % keyLen];
        }
        // 对S进行置换 ?
        int j = 0;
        for (int i = 0; i < len; i++) {
            j = (j + S[i] + T[i]) % len;
            swap(S, i, j);
        }
        // 生成密钥 对S操作
        List<Integer> key = new ArrayList<>();
        int t, index = 0;
        int i = 0;
        j = 0;
        while (index < lenM) {
            i = (i + 1) % len;
            j = (j + S[i]) % len;
            swap(S, i, j);
            t = (S[i] + S[j]) % len;
            key.add(S[t]);
            index++;
        }
        return key;
    }

    public void swap(int[] a, int i, int j) {
        if (i != j) {
            a[i] = a[i] + a[j];
            a[j] = a[i] - a[j];
            a[i] = a[i] - a[j];
        }
    }

    public static void main(String[] args) {
        RC4 rc4 = new RC4();
        // 种子密钥
        int[] k = {5, 6, 7};
        List<Integer> ret = new ArrayList<>();
        ret = rc4.RC4(8, k, 8);
        Iterator<Integer> in = ret.iterator();
        while (in.hasNext()) {
            System.out.println(Integer.toBinaryString(in.next()));
        }
    }
}
