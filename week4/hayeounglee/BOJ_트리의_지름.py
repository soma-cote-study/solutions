import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

def dfs(u, now):
    for v, w in graph[u]:
        if dist[v] == -1:
            dist[v] = now + w
            dfs(v, dist[v])

N = int(input())
graph = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    a, b, d = map(int, input().split())
    graph[a].append((b, d))
    graph[b].append((a, d))

dist = [-1] * (N + 1)
dist[1] = 0
dfs(1, 0)

start = dist.index(max(dist))

dist = [-1] * (N + 1)
dist[start] = 0
dfs(start, 0)

print(max(dist))
