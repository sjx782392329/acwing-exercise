package union_find;

import java.util.Scanner;
/**
 * https://www.acwing.com/problem/content/838/
 * */
public class Main {
    // 用来存储父亲，p[x] 是指的是 x 的父亲
    static int[] p = new int[100010];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            // 最开始节点的父亲就是节点本身
            p[i] = i;
        }
        while (m -- > 0) {
            String op = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if ("M".equals(op)) {
                p[find(a)] = find(b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }

    }
    // find 查找 x 的祖先，并且做了路径压缩
    private static int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
