n = int(input())
numbers = list(map(int, input().split()))

dp = [[0] * 21 for i in range(len(numbers))]
dp[0][numbers[0]] = 1

for i in range(1, len(numbers) - 1):
    for j in range(21):
        prev = dp[i - 1][j] # 연산 횟수
        if prev != 0: # 계산한 값이 존재
            if j - numbers[i] >= 0:
                dp[i][j - numbers[i]] += prev
            if j + numbers[i] <= 20:
                dp[i][j + numbers[i]] += prev

print(dp[len(numbers) - 2][numbers[-1]])
