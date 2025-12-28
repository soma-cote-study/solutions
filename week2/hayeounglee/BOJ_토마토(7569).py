import sys
from collections import deque
input = sys.stdin.readline

def isAllRotten():
    for x in range(N):
        for y in range(M):
            for z in range(H):
                if graph[x][y][z] == 0:
                    return False
    return True

def bfs():
    q = deque()
    answer = 0

    for x in range(N):
        for y in range(M):
            for z in range(H):
                if graph[x][y][z] == 1:
                    q.append((0, x, y, z))

    while q:
        time, x, y, z = q.popleft()
        answer = time

        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]

            if nx < 0 or ny < 0 or nz < 0 or nx >= N or ny >= M or nz >= H:
                continue

            if graph[nx][ny][nz] == 0:
                graph[nx][ny][nz] = 1
                q.append((time + 1, nx, ny, nz))

    if isAllRotten():
        return answer
    else:
        return -1

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

M, N, H = map(int, input().split())  # 가로(M), 세로(N)
graph = [[[0]*H for _ in range(M)] for _ in range(N)]

for z in range(H):
    for x in range(N):
        row = list(map(int, input().split()))
        for y in range(M):
            graph[x][y][z] = row[y]

print(bfs())
