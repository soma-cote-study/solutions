import sys
from collections import deque
from itertools import combinations
from copy import deepcopy

input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs(temp):
    q = deque(virus)

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and nx < n and ny >= 0 and ny < m:
                if temp[nx][ny] == 0:
                    temp[nx][ny] = 2
                    q.append((nx, ny))

def get_score(temp):
    count = 0
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 0:
                count += 1
    return count

n, m = map(int, input().split())
graph = []
temp = []
blanks = []
virus = []
result = 0

for i in range(n):
    graph.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            blanks.append((i, j))
        if graph[i][j] == 2:
            virus.append((i, j))

for locations in combinations(blanks, 3):
    temp = deepcopy(graph)
    for loc in locations:
        temp[loc[0]][loc[1]] = 1

    bfs(temp)
    result = max(result, get_score(temp))

print(result)
