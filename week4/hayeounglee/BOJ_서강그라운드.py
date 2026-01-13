INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

n, m, r = map(int, input().split())
items = list(map(int, input().split()))
graph = [[INF] * (n) for _ in range(n)]

for a in range(n):
    for b in range(n):
        if a == b:
            graph[a][b] = 0

for _ in range(r):
    a, b, c = map(int, input().split())
    a -= 1
    b -= 1
    graph[a][b] = c
    graph[b][a] = c

for k in range(n):
    for a in range(n):
        for b in range(n):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

answer = 0

for a in range(n):
    temp = 0
    for b in range(n):
        if graph[a][b] == INF or graph[a][b] > m:
            continue
        temp += items[b]
    answer = max(answer, temp)

print(answer)
