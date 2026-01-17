import heapq
import math
import sys
input = sys.stdin.readline

INF = 10**15

def dijkstra(start):
    dist = [INF] * (N + 1)
    pq = []
    heapq.heappush(pq, (0, start))
    dist[start] = 0

    while pq:
        cur_dist, now = heapq.heappop(pq)
        if dist[now] < cur_dist:
            continue
        for nxt, w in graph[now]:
            cost = cur_dist + w
            if cost < dist[nxt]:
                dist[nxt] = cost
                heapq.heappush(pq, (cost, nxt))
    return dist


N, W = map(int, input().split())
M = float(input())

coords = [None]
for _ in range(N):
    x, y = map(int, input().split())
    coords.append((x, y))

graph = [[] for _ in range(N + 1)]

# 이미 연결된 통로 (비용 0)
for _ in range(W):
    a, b = map(int, input().split())
    graph[a].append((b, 0))
    graph[b].append((a, 0))

# 거리 M 이하이면 간선 추가
for i in range(1, N + 1):
    x1, y1 = coords[i]
    for j in range(i + 1, N + 1):
        x2, y2 = coords[j]
        dist = math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)
        if dist <= M:
            graph[i].append((j, dist))
            graph[j].append((i, dist))

dist = dijkstra(1)

print(int(dist[N] * 1000))
