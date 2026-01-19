import heapq
import sys
input = sys.stdin.readline

INF = int(1e10)

def dijkstra(start):
    while q:
        cur_dist, now = heapq.heappop(q)

        if cur_dist > distance[now]:
            continue

        for next_node, next_cost in graph[now]:
            cost = cur_dist + next_cost
            if cost < distance[next_node]:
                distance[next_node] = cost
                heapq.heappush(q, (cost, next_node))


TC = int(input())
for _ in range(TC):
    n, d, c = map(int, input().split())
    graph = [[] for _ in range(n + 1)]
    distance = [INF] * (n + 1)

    for _ in range(d):
        a, b, s = map(int, input().split())
        graph[b].append((a, s))  # b → a, 시간 s

    q = []
    heapq.heappush(q, (0, c))
    distance[c] = 0

    dijkstra(c)

    count = 0
    max_time = 0

    for i in range(1, n + 1):
        if distance[i] != INF:
            count += 1
            max_time = max(max_time, distance[i])

    print(count, end = ' ')
    print(max_time)
