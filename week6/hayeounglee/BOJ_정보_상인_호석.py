import sys
import heapq

input = sys.stdin.readline

Q = int(input())
info = dict()
answer = 0

for _ in range(Q):
    query = input().split()

    if query[0] == '1':
        name = query[1]
        k = int(query[2])
        values = map(int, query[3:])

        if name not in info:
            info[name] = []

        for v in values:
            heapq.heappush(info[name], -v)

    else:
        name = query[1]
        k = int(query[2])

        if name in info:
            for _ in range(k):
                if not info[name]:   # heap 비었으면 종료
                    break
                answer += -heapq.heappop(info[name])

print(answer)
