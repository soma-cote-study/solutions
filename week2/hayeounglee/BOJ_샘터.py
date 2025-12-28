import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    global count, answer

    while q:
        x, dist = q.popleft()

        for nx in (x - 1, x + 1):
            if nx not in visited:
                visited.add(nx)
                q.append((nx, dist + 1))

                count += 1
                answer += dist + 1

                if count == K:
                    return


N, K =  map(int, input().split()) # 샘터, 집
sams = list(map(int, input().split()))
visited = set()
q = deque()

count = 0
answer = 0

for s in sams:
    q.append((s, 0))
    visited.add(s)

bfs()
print(answer)
