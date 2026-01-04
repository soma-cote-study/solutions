from collections import deque
import sys

input = sys.stdin.readline

n = int(input())
q = deque()

for _ in range(n):
    command = list(input().split())
    if command[0] == 'push':
        q.append(command[1])
    elif command[0] == 'pop':
        if len(q) == 0:
            print(-1)
        else:
            print(q.popleft())
    elif command[0] == 'front':
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
    elif command[0] == 'back':
        if len(q) == 0:
            print(-1)
        else:
            print(q[-1])
    elif command[0] == 'empty':
        print(1 if len(q) == 0 else 0)
    elif command[0] == 'size':
        print(len(q))
