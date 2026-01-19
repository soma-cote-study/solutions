import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y):
    queue = deque([(x, y)])
    dist[x][y] = 0

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= M :
                continue

            if graph[nx][ny] == 0:
                continue

            if dist[nx][ny] != -1 :
                continue

            dist[nx][ny] = dist[x][y] + 1
            queue.append((nx, ny))
    return 0


N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
dist = [[-1] * M for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(N):
    for j in range(M):
        if graph[i][j] == 2:
            start_x, start_y = i, j

bfs(start_x, start_y)

for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            print(0, end=' ')
        else:
            print(dist[i][j], end=' ')
    print()
