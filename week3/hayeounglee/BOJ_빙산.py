import sys
from collections import deque
input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
new_board = [row[:] for row in board]

def bfs(x, y, visited):
    q = deque()
    q.append((x, y))
    visited[x][y] = True

    while q:
        cx, cy = q.popleft()
        for d in range(4):
            nx = cx + dx[d]
            ny = cy + dy[d]
            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] > 0 and not visited[nx][ny]:
                    visited[nx][ny] = True
                    q.append((nx, ny))

year = 0

while True:
    visited = [[False] * M for _ in range(N)]
    cnt = 0

    for i in range(N):
        for j in range(M):
            if board[i][j] > 0 and not visited[i][j]:
                cnt += 1
                if cnt >= 2:
                    print(year)
                    sys.exit()
                bfs(i, j, visited)

    if cnt == 0:
        print(0)
        sys.exit()

    for x in range(N):
        for y in range(M):
            if board[x][y] > 0:
                sea = 0
                for d in range(4):
                    nx = x + dx[d]
                    ny = y + dy[d]
                    if 0 <= nx < N and 0 <= ny < M:
                        if board[nx][ny] == 0:
                            sea += 1
                new_board[x][y] = max(0, board[x][y] - sea)

    board = [row[:] for row in new_board]
    year += 1
