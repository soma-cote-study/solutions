from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
H, W, S_R, S_C, F_R, F_C = map(int, input().split())
visited = [[-1]*M for _ in range(N)]

S_R -= 1
S_C -= 1
F_R -= 1
F_C -= 1

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def is_empty(x, y): # 네모 안이 0이여야 함
    if x < 0 or y < 0 or x + H > N or y + W > M:
        return False
    for i in range(H):
        for j in range(W):
            if graph[x + i][y + j] == 1:
                return False
    return True

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = 0

    while queue:
        x, y = queue.popleft() # 직사각형의 왼쪽 위 좌표

        if x == F_R and y == F_C:
            return visited[x][y]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if visited[nx][ny] != -1: # 이미 방문했다면
                continue

            if is_empty(nx, ny):
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))

    return -1

# BFS를 수행한 결과 출력
print(bfs(S_R, S_C))
