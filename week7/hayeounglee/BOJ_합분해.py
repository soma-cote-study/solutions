import sys

input = sys.stdin.readline
n, k = map(int, input().split())
MOD = 10**9a

dp = [[0] * (n + 1) for _ in range(k + 1)]

dp[0][0] = 1

for i in range(1, k + 1):
    for j in range(n + 1):
        if j == 0:
            dp[i][j] = dp[i - 1][j] % MOD
        else:
            dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD

print(dp[k][n] % MOD)
