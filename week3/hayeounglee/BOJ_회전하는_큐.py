import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
choose = list(map(int, input().split()))

answer = 0
rotateQ = deque(range(1, N + 1))


for k in choose:
    idx = rotateQ.index(k)

    if idx <= len(rotateQ) - idx: # 왼쪽 회전이 더 빠른 경우
        rotateQ.rotate(-idx)
        answer += idx
    else:
        rotateQ.rotate(len(rotateQ) - idx)
        answer += len(rotateQ) - idx

    rotateQ.popleft()

print(answer)
