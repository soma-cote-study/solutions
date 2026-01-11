
import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

def BellmanFord():
    # N번 반복
    for i in range(1, N + 1):
        for u in range(1, N + 1):
            for v, w in graph[u]:
                if dist[v] > dist[u] + w:
                    dist[v] = dist[u] + w
                    # N번째에서도 갱신되면 음의 사이클
                    if i == N:
                        return True
    return False


TC = int(input())

for _ in range(TC):
    N, M, W = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    dist = [0] * (N + 1)

    has_negative_cycle = False

    for _ in range(M):
        S, E, T = map(int, input().split())
        graph[S].append((E, T))
        graph[E].append((S, T))
    for _ in range(W):
        S, E, T = map(int, input().split())
        graph[S].append((E, -T))

    BellmanFord()


    if BellmanFord():
        print("YES")
    else:
        print("NO")
