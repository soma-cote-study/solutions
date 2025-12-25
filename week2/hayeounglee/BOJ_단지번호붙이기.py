import sys
from collections import deque
input = sys.stdin.readline

def bfs(i, j):
    queue = deque([(i, j)])
    graph[i][j] = 0 # 방문 처리
    cnt = 1

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= N :
                continue

            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))
                cnt += 1

    return cnt


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

N = int(input())  # N * N
graph = [list(map(int, input().strip())) for _ in range(N)]

total_danji = 0
result = []

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            total_danji += 1
            count = bfs(i, j)
            result.append(count)

result.sort()

print(total_danji)
for r in result:
    print(r)
