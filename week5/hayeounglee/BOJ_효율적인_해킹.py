# 시간초과 뜨는 DFS 코드 (정답은 아니지만 공부차원에서 적어봄)

import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

def dfs(start):
    global count
    visited[start] = True

    for s in graph[start]:
        if not visited[s]:
            count += 1
            dfs(s)

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

max_c = -1
result = []

for _ in range(M):
    a, b = map(int, input().split())
    graph[b].append(a)

for i in range(1, N + 1):
    count = 1
    visited = [False] * (N + 1)
    dfs(i)
    if max_c < count :
        max_c = count
        result = [i] # 주의)새로운 최대값이 나오면 기존에 저장되어 있던 결과값은 필요없음
    elif max_c == count:
        result.append(i)

print(*result)
