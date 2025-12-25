from collections import deque
MAX_DISTANCE = 100001

def bfs(loc):
    time = 0
    q = deque()
    dist[loc] = 0

    q.append((time, loc))

    while q:
        time, loc = q.popleft()

        if loc == K:
            return time

        nx = loc * 2 # 주의) 순간이동은 0초 후에
        if nx < MAX_DISTANCE and dist[nx] == -1:
            dist[nx] = dist[loc] # 방문 여부 표시 + 이전 내용 기록
            q.append((time, nx))

        for nx in (loc - 1, loc + 1):
            if 0 <= nx < MAX_DISTANCE and dist[nx] == -1:
                dist[nx] = dist[loc] + 1
                q.append((time + 1, nx))


N, K = map(int, input().split())
dist = [-1] * (MAX_DISTANCE)


print(bfs(N))
