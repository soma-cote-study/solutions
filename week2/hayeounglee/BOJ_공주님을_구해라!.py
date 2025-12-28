from collections import deque

def bfs(x, y):
    q = deque([(False, x, y)])
    dist1[0][0] = 0   # 검 없음
    dist2[0][0] = 0   # 검 있음

    while q:
        hasSword, x, y = q.popleft()

        # 현재 상태에 맞는 dist 선택
        cur_dist = dist2 if hasSword else dist1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue

            if not hasSword:
                if graph[nx][ny] == 1:
                    continue

                if graph[nx][ny] == 2 and dist2[nx][ny] == -1:
                    dist2[nx][ny] = cur_dist[x][y] + 1
                    q.append((True, nx, ny))
                    continue

                if graph[nx][ny] == 0 and dist1[nx][ny] == -1:
                    dist1[nx][ny] = cur_dist[x][y] + 1
                    q.append((False, nx, ny))

            else:
                if dist2[nx][ny] == -1:
                    dist2[nx][ny] = cur_dist[x][y] + 1
                    q.append((True, nx, ny))


dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

N, M, T = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

dist1 = [[-1] * M for _ in range(N)]  # 검 없음
dist2 = [[-1] * M for _ in range(N)]  # 검 있음

bfs(0, 0)

ans = float('inf')
if dist1[N-1][M-1] != -1:
    ans = dist1[N-1][M-1]
if dist2[N-1][M-1] != -1:
    ans = min(ans, dist2[N-1][M-1])

print(ans if ans <= T else "Fail")
