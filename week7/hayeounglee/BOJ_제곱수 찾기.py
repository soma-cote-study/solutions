import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(N)]

answer = -1

for i in range(N):
    for j in range(M):
        for dr in range(-N, N + 1):
            for dc in range(-M, M + 1):
                if dr == 0 and dc == 0:
                    continue

                x, y = i, j
                num = 0

                while 0 <= x < N and 0 <= y < M:
                    num = num * 10 + board[x][y]
                    root = int(num ** 0.5)
                    if root * root == num:
                        answer = max(answer, num)

                    x += dr
                    y += dc

print(answer)
