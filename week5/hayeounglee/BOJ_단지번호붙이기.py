# dfs

import sys
input = sys.stdin.readline

def dfs(x, y):
    global count

    graph[x][y] = 0

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= N or ny >= N :
            continue
        if graph[nx][ny] == 0:
            continue
        if graph[nx][ny] == 1:
            count += 1
            graph[nx][ny] = 0
            dfs(nx, ny)
    return


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
            count = 1
            dfs(i, j)
            result.append(count)

result.sort()

print(total_danji)
for r in result:
    print(r)
