from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

R, C = map(int, input().split())
graph = [list(input().rstrip()) for _ in range(R)]

jq = deque()
visited = [[-1] * C for _ in range(R)]

fq = deque()
fire_time = [[-1] * C for _ in range(R)]

for i in range(R):
    for j in range(C):
        if graph[i][j] == 'J':
            graph[i][j] = '.'
            jq.append((i, j))
            visited[i][j] = 0
        if graph[i][j] == 'F':
            fq.append((i, j))
            fire_time[i][j] = 0

while fq:
    x, y = fq.popleft()
    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < R and 0 <= ny < C:
            if graph[nx][ny] != '#' and fire_time[nx][ny] == -1:
                fire_time[nx][ny] = fire_time[x][y] + 1
                fq.append((nx, ny))

def bfs():
    while jq:
        x, y = jq.popleft()
        t = visited[x][y]

        if x == 0 or y == 0 or x == R -1 or y == C - 1:
            return t + 1 # 다음 이동에서 격자를 벗어나는 순간 -> 탈출

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            nt = t + 1

            if nx < 0 or ny < 0 or nx >= R or ny >= C or graph[nx][ny] == '#':
                continue
            if fire_time[nx][ny] != -1 and fire_time[nx][ny] <= nt:
                continue
            if graph[nx][ny] == '.' and visited[nx][ny] == -1:
                jq.append((nx, ny))
                visited[nx][ny] = nt

    return "IMPOSSIBLE"


print(bfs())
