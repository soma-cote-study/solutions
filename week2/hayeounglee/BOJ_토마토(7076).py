import sys
from collections import deque
input = sys.stdin.readline

def isAllRotten():
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                return False
    return True

def bfs():
    q = deque()
    answer = 0

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                q.append((0, i, j))

    while q:
        time, x, y = q.popleft()
        answer = time

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue

            if graph[nx][ny] == 0:
                graph[nx][ny] = 1
                q.append((time + 1, nx, ny))

    if isAllRotten():
        return answer
    else:
        return -1

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

M, N = map(int, input().split())  # 가로(M), 세로(N)
graph = [list(map(int, input().split())) for _ in range(N)]

print(bfs())
