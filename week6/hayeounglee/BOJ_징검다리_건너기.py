import sys
input = sys.stdin.readline
INF = int(1e6)

N = int(input())
stones = [None] + [tuple(map(int, input().split())) for _ in range(N - 1)]
K = int(input())

# dp[i][0]: i번 돌, 매우 큰 점프 아직 안 씀
# dp[i][1]: i번 돌, 매우 큰 점프 이미 씀
dp = [[INF, INF] for _ in range(N + 1)]

dp[1][0] = 0

for i in range(2, N + 1):
    # 작은 점프
    dp[i][0] = min(dp[i][0], dp[i - 1][0] + stones[i - 1][0])
    dp[i][1] = min(dp[i][1], dp[i - 1][1] + stones[i - 1][0])

    # 큰 점프
    if i >= 3:
        dp[i][0] = min(dp[i][0], dp[i - 2][0] + stones[i - 2][1])
        dp[i][1] = min(dp[i][1], dp[i - 2][1] + stones[i - 2][1])

    # 매우 큰 점프
    if i >= 4:
        dp[i][1] = min(dp[i][1], dp[i - 3][0] + K)

print(min(dp[N]))
