import sys
input = sys.stdin.readline

def dfs(path):
    if len(path) == L:
        print("".join(path))
        return

    prev = ''
    for i in range(L):
        if not used[i] and chars[i] != prev:
            used[i] = True
            dfs(path + [chars[i]])
            used[i] = False
            prev = chars[i]

N = int(input())
for _ in range(N):
    chars = sorted(input().strip())
    L = len(chars)
    used = [False] * L
    dfs([])
