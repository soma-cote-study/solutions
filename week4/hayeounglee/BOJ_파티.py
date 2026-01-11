import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

def dijkstra(start, graph):
    dist = [INF] * (N + 1)
    q = []
    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        d, now = heapq.heappop(q)
        if dist[now] < d:
            continue
        for nxt, w in graph[now]:
            cost = d + w
            if dist[nxt] > cost:
                dist[nxt] = cost
                heapq.heappush(q, (cost, nxt))
    return dist


N, M, X = map(int, input().split())

graph = [[] for _ in range(N + 1)]
reverse_graph = [[] for _ in range(N + 1)]

for _ in range(M):
    A, B, T = map(int, input().split())
    graph[A].append((B, T))         # 정방향
    reverse_graph[B].append((A, T)) # 역방향

# X → 모든 마을
dist_from_X = dijkstra(X, graph)

# 모든 마을 → X
dist_to_X = dijkstra(X, reverse_graph)

answer = 0
for i in range(1, N + 1):
    answer = max(answer, dist_from_X[i] + dist_to_X[i])

print(answer)
