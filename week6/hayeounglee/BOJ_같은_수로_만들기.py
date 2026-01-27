import sys

input = sys.stdin.readline

n = int(input().strip())
arr = [int(input().strip()) for _ in range(n)]

current = arr[0]
ans = 0

max_val = max(arr)

for v in arr[1:]:
    # 올라가는 숫자일 때
    if v > current:
        ans += (v - current)
        current = v
    else:
        current = v

ans += (max_val - current)

print(ans)
