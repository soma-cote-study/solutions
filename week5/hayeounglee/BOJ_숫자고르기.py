import sys
from collections import deque
input = sys.stdin.readline

def dfs(v, visited):
    global found

    for vertex in graph[v]:
        if vertex == start: # 시작지점과 같다면(사이클이 존재한다면)
            found = True
            return

        if not visited[vertex]:
            visited[vertex] = True
            dfs(vertex, visited)

N = int(input())  # 사람의 수, 친구 관계 수
graph = [[] for _ in range(N + 1)]
for a in range(1, N + 1):
    b = int(input())
    graph[a].append(b)

answer = set()

for v in range(1, N + 1):
    found = False
    start = v
    visited = [False] * (N + 1)
    visited[v] = True

    dfs(v, visited)
    if found:
        for i in range(1, N + 1):
            if visited[i] == True:
                if i not in answer:
                    answer.add(i)

answer = sorted(answer)
print(len(answer))
for i in answer:
    print(i)
