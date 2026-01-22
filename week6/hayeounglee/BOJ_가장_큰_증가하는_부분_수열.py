n = int(input())
array = list(map(int, input().split()))

dp = array[:]

for i in range(1, n):
    dp[i] = array[i]
    for j in range(0, i):
        if array[j] < array[i]:
            dp[i] = max(dp[i], dp[j] + array[i])

print(max(dp))
