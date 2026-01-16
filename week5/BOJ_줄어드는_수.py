import sys
input = sys.stdin.readline

N = int(input())

nums = []
nums.append(0)

def dfs(num, last):
    nums.append(num)
    for next_digit in range(last - 1, -1, -1):
        dfs(num * 10 + next_digit, next_digit)

# 0~9를 시작 숫자로 사용
for i in range(10):
    dfs(i, i)

nums.sort()

if N >= len(nums):
    print(-1)
else:
    print(nums[N])
