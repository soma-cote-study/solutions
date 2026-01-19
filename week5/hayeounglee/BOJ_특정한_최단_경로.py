import sys
import heapq
input = sys.stdin.readline
INF = int(1e10)

def dijkstra(start):
    dist = [INF]*(N+1)
    dist[start] = 0
    pq = [(0, start)]
    while pq:
        cd, now = heapq.heappop(pq)

        if cd > dist[now]: continue
        for nxt, w in graph[now]:
            nd = cd + w
            if nd < dist[nxt]:
                dist[nxt] = nd
                heapq.heappush(pq, (nd, nxt))
    return dist

N, E = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(E):
    a,b,c = map(int, input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

v1, v2 = map(int, input().split())

d1 = dijkstra(1)
dv1 = dijkstra(v1)
dv2 = dijkstra(v2)

case1 = d1[v1] + dv1[v2] + dv2[N]
case2 = d1[v2] + dv2[v1] + dv1[N]

ans = min(case1, case2)
print(ans if ans < INF else -1)
