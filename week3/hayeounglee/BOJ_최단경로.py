import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

V, E = map(int, input().split()) # 도시의 개수, 노선의 개수
K = int(input())

graph = [[] for _ in range(V + 1)]
distance = [INF] * (V + 1)

for _ in range(E):
    u, v, w =  map(int, input().split())
    graph[u].append((v, w))

def dikstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q) # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        if distance[now] < dist: # 이미 처리되었다면
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]: # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dikstra(K)

for i in range(1, V + 1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
