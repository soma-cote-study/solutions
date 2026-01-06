from collections import deque
import sys

input = sys.stdin.readline

N = int(input())
q = deque(range(1, N+1))

while len(q) > 1:
    q.popleft()
    if q:
        q.append(q.popleft())

print(q[0])
