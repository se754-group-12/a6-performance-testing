package com.code67.quizfeedback;

public final class FuzzyMatcher {

    private FuzzyMatcher() {
    }

    public static int distance(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + cost
                );
            }
        }

        return dp[m][n];
    }

    // Threshold scales with the correct answer's length so short answers do
    // not accept obviously wrong words (e.g., "super" vs "buyer" both 5 chars
    // and distance 2 would otherwise pass).
    public static boolean isClose(String submission, String correctAnswer) {
        int threshold = Math.max(1, correctAnswer.length() / 4);
        return distance(submission, correctAnswer) <= threshold;
    }
}
