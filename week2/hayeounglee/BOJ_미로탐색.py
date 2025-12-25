from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

N, M = map(int, input().split())
array = [list(map(int, input().strip())) for _ in range(N)]

def bfs(x, y):
    q = deque()
    q.append((x, y))

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >=N or ny >= M or array[nx][ny] != 1: # 이동할 수 없는 칸
                continue

            array[nx][ny] = array[x][y] + 1 # 처음 방문했을 때문 실행
            q.append((nx, ny))

            if nx == N-1 and ny == M-1: # 도착점 도달 즉시 종료
                return

bfs(0, 0)
print(array[N-1][M-1])
