import sys
from collections import deque
input = sys.stdin.readline


def dfs(n, depth, visited):
    global found

    if depth == 4:
        found = True
        return

    for i in graph[n]:
        if not visited[i]:
            visited[i] = True
            dfs(i, depth + 1, visited)
            visited[i] = False
            # if found:
            #   return


M, N = map(int, input().split())  # 사람의 수, 친구 관계 수
graph = [[] for _ in range(M)]
for _ in range(N):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

found = False

for v in range(M):
    visited = [False] * M
    visited[v] = True

    dfs(v, 0, visited)

    if found:
        break

print(1 if found else 0)
