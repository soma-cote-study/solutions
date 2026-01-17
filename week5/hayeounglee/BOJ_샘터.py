import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    count = 0
    answer = 0

    while q:
        x, dist = q.popleft()

        for nx in (x - 1, x + 1):
            if nx not in visited:
                visited.add(nx)
                q.append((nx, dist + 1))

                count += 1
                answer += dist + 1

                if count == K:
                    return answer

    return answer


N, K = map(int, input().split())
sams = list(map(int, input().split()))

visited = set()
q = deque()

for s in sams:
    visited.add(s)
    q.append((s, 0))

print(bfs())
