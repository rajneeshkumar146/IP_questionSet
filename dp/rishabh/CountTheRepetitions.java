
public class CountTheRepetitions {
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        boolean c[] = new boolean[26];
        for (int k = 0; k < len1; k++) {
            c[s1.charAt(k) - 'a'] = true;
        }

        for (int k = 0; k < len2; k++) {
            if (!c[s2.charAt(k) - 'a']) {
                return 0;
            }
        }


        int[] dp = new int[len1];
        for (int i = 0; i < len1; i++) {
            dp[i] = findNextIndex(s1, s2, i);
        }

        int []fast = new int[len1];
        for (int i = 0; i < len1; i++) {
            int t = i;
            int step = 0;
            for (int j = 0; j < 1000; j++) {
                step += dp[t];
                t = t + dp[t];
                t %= len1;
            }
    
            fast[i] = step;
        }

        int i = 0;
        int limit = len1 * n1;
        int sum = 0;
        while(i < limit) {
            if (dp[i%len1] < 0) break;
            int fastNext = i + fast[i%len1];
            if (fastNext <= limit) {
                i = fastNext;
                sum+=1000;
                continue;
            }

            i = i + dp[i%len1];
            if (i <= limit)
            sum++;
           
        }

        return sum/n2;
    }

    private int findNextIndex(String s1, String s2, int i) {
        int j = 0;
        int step = 0;
        while(j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }

            i++;
            step++;
            i %= s1.length();
        }
        return step;
    }
}
