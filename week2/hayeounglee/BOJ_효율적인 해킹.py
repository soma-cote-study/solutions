import sys
from collections import deque
input = sys.stdin.readline

# bfs 탐색 : 노드의 개수(N)이 10,000이기 떄문에 dfs를 사용하면 재귀함수 깊이가 한계를 넘어갈 수 있음
def bfs(start):
    count = 0
    visited = [False] * (N + 1)
    q = deque([start])
    visited[start] = True

    while q:
        v = q.popleft()
        for k in graph[v]:
            if visited[k] == False:
                count += 1
                visited[k] = True
                q.append(k)

    return count


N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

max_c = -1
result = []

for _ in range(M):
    a, b = map(int, input().split())
    graph[b].append(a)

for i in range(1, N + 1):
    c = bfs(i)
    if max_c < c :
        max_c = c
        result = [i] # 주의)새로운 최대값이 나오면 기존에 저장되어 있던 결과값은 필요없음
    elif max_c == c:
        result.append(i)

print(*result) #sorted(result)을 하면 리스트 형태까지 함께 나옴(ex.[1,2])



