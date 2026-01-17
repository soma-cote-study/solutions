import heapq
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

N = int(input())
A, B, C = map(int, input().split())
M = int(input())

graph = [[] for _ in range(N + 1)]
for _ in range(M):
    D, E, L = map(int, input().split())
    graph[D].append((E, L))
    graph[E].append((D, L))  # 무방향 그래프

distA = dijkstra(A)
distB = dijkstra(B)
distC = dijkstra(C)

answer = 0
max_dist = -1

for i in range(1, N + 1): # i에 자취할 때
    closest = min(distA[i], distB[i], distC[i])
    if closest > max_dist:
        max_dist = closest
        answer = i

print(answer)
