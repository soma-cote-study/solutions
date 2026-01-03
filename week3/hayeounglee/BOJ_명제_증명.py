import sys
input = sys.stdin.readline
INF = int(1e9)

def idx(c):
    if 'A' <= c <= 'Z':
        return ord(c) - ord('A')
    else:
        return ord(c) - ord('a') + 26

def ch(i):
    if i < 26:
        return chr(i + ord('A'))
    else:
        return chr(i - 26 + ord('a'))

N = int(input())
n = 52

graph = [[INF] * n for _ in range(n)]

for _ in range(N):
    a, _, b = input().split()
    graph[idx(a)][idx(b)] = 1

for k in range(n):
    for a in range(n):
        for b in range(n):
            if graph[a][k] != INF and graph[k][b] != INF:
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
result = []
for a in range(n):
    for b in range(n):
        if a != b and graph[a][b] != INF:
            result.append((a, b))

print(len(result))
for a, b in result:
    print(f"{ch(a)} => {ch(b)}")
