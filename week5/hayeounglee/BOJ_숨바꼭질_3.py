import heapq

MAX_DISTANCE = 100001

def dijkstra(start):
    pq = []
    dist[start] = 0
    heapq.heappush(pq, (0, start))

    while pq:
        time, loc = heapq.heappop(pq)

        # 이미 더 짧은 경로로 방문한 경우 스킵
        if time > dist[loc]:
            continue

        if loc == K:
            return time

        nx = loc * 2
        if nx < MAX_DISTANCE and dist[nx] > time:
            dist[nx] = time
            heapq.heappush(pq, (time, nx))

        for nx in (loc - 1, loc + 1):
            if 0 <= nx < MAX_DISTANCE and dist[nx] > time + 1:
                dist[nx] = time + 1
                heapq.heappush(pq, (time + 1, nx))


N, K = map(int, input().split())
dist = [100001] * MAX_DISTANCE

print(dijkstra(N))
