import sys
input = sys.stdin.readline

N, M = map(int, input().split())
INF = int(1e9)

dist = [[INF] * N for _ in range(N)]
for i in range(N):
    dist[i][i] = 0

for _ in range(M):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    dist[a][b] = 1
    dist[b][a] = 1

for k in range(N):
    for i in range(N):
        for j in range(N):
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

answer = INF
c1, c2 = 0, 1

for i in range(N):
    for j in range(i + 1, N):
        total = 0
        for k in range(N):
            total += 2 * min(dist[k][i], dist[k][j]) # 왕복 시간의 합

        if total < answer:
            answer = total
            c1, c2 = i, j

print(c1 + 1, c2 + 1, answer)
