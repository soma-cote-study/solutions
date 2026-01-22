import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))

left = 0
odd = 0
answer = 0

for right in range(N):
    if arr[right] % 2 == 1:
        odd += 1

    while odd > K:
        if arr[left] % 2 == 1:
            odd -= 1
        left += 1

    answer = max(answer, (right - left + 1) - odd)

print(answer)
