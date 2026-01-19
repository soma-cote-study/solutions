import heapq

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

M, N = map(int, input().split())
array = [list(map(int, input().strip())) for _ in range(N)]

INF = int(1e9)
dist = [[INF] * M for _ in range(N)]

def dijkstra():
    pq = []
    heapq.heappush(pq, (0, 0, 0))
    dist[0][0] = 0

    while pq:
        w, x, y = heapq.heappop(pq)

        if x == N - 1 and y == M - 1:
            return w

        if dist[x][y] < w:
            continue

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue

            nw = w + array[nx][ny]

            if dist[nx][ny] > nw:
                dist[nx][ny] = nw
                heapq.heappush(pq, (nw, nx, ny))

print(dijkstra())
