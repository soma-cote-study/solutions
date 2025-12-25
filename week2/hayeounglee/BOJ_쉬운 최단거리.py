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

            if graph[nx][ny] == 0: # 갈 수 없는 땅
                continue # 나중에 distance 출력을 0으로 해야 함
            # 왜 distance[nx][ny] = 0 을 하지 않은가? -> 이건 시작 지점만 0으로 초기화 가능!

            if dist[nx][ny] != -1 : # 방문을 했다면 이미 최단 경로가 계산된거기 때문에 pass
                continue

            # 아직 방문하지 않았다면 최단 경로를 계산해야 하기 때문에
            dist[nx][ny] = dist[x][y] + 1
            queue.append((nx, ny))
    return 0


N, M = map(int, input().split()) # 세로, 가로
graph = [list(map(int, input().split())) for _ in range(N)]
dist = [[-1] * M for _ in range(N)]

# 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 목표 지점 찾기
for i in range(N):
    for j in range(M):
        if graph[i][j] == 2:
            start_x, start_y = i, j

bfs(start_x, start_y)

for i in range(N):
    for j in range(M):
        if graph[i][j] == 0: # distance에서는 -1인 값
            print(0, end=' ')
        else:
            print(dist[i][j], end=' ')
    print()
