import sys
input = sys.stdin.readline
INF = 10**18

N, M = map(int, input().split())
edges = []

for _ in range(M):
    A, B, C = map(int, input().split())
    edges.append((A, B, C))

dist = [INF] * (N + 1)
dist[1] = 0  # 시작 도시

# 벨만–포드
for i in range(N - 1):
    updated = False
    for u, v, w in edges:
        if dist[u] != INF and dist[u] + w < dist[v]:
            dist[v] = dist[u] + w
            updated = True
    if not updated:  # 더 이상 갱신 안 되면 조기 종료
        break

# 음수 사이클 검사
for u, v, w in edges:
    if dist[u] != INF and dist[u] + w < dist[v]:
        print(-1)
        sys.exit(0)

for i in range(2, N + 1):
    if dist[i] == INF:
        print(-1)
    else:
        print(dist[i])
