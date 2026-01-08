import sys
input = sys.stdin.readline
INF = 10**9

N = int(input())
M = int(input())
dist = [[INF] * N for _ in range(N)]

for _ in range(M):
    a, b, d = map(int, input().split())
    a -= 1
    b -= 1

    dist[a][b] = min(dist[a][b], d)

for i in range(N):
    dist[i][i] = 0

for k in range(N):
    for i in range(N):
        for j in range(N):
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

for i in range(N):
    for j in range(N):
        print(0 if dist[i][j] == INF else dist[i][j], end=" ")
    print()
