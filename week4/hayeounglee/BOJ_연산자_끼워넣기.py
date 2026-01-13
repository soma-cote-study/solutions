import sys
from itertools import permutations

input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

min_value = 1e9
max_value = -1e9

def dfs(nxt_idx, now):
    global min_value, max_value, add, sub, mul, div

    if nxt_idx == n:
        min_value = min(min_value, now)
        max_value = max(max_value, now)
        return

    if add > 0:
        add -= 1
        dfs(nxt_idx + 1, now + data[nxt_idx])
        add += 1

    if sub > 0:
        sub -= 1
        dfs(nxt_idx + 1, now - data[nxt_idx])
        sub += 1

    if mul > 0:
        mul -= 1
        dfs(nxt_idx + 1, now * data[nxt_idx])
        mul += 1

    if div > 0:
        div -= 1
        dfs(nxt_idx + 1, int(now / data[nxt_idx]))
        div += 1

dfs(1, data[0])
print(max_value)
print(min_value)
