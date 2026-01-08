import sys
input = sys.stdin.readline
INF = 10**9

N, M = map(int, input().split())
dist = [[INF] * N for _ in range(N)]
result = INF

for _ in range(M):
    a, b, d = map(int, input().split())
    a -= 1
    b -= 1

    dist[a][b] = d

for i in range(N):
    dist[i][i] = INF

for k in range(N):
    for i in range(N):
        for j in range(N):
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

for i in range(N):
    result = min(result, dist[i][i])

if result == INF:
    print(-1)
else:
    print(result)
