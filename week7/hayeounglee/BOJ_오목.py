import sys
input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(19)]

# → ↓ ↘ ↗
dirs = [(0, 1), (1, 0), (1, 1), (-1, 1)]

cnt = 0

def dfs(x, y, d, color):
    global cnt

    nx = x + dirs[d][0]
    ny = y + dirs[d][1]

    if 0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == color:
        cnt += 1
        dfs(nx, ny, d, color)


for i in range(19):
    for j in range(19):
        if board[i][j] == 0:
            continue

        color = board[i][j]

        for d in range(4):
            # 6목 방지: 시작점 이전 칸에 같은 돌 있으면 패스
            px = i - dirs[d][0]
            py = j - dirs[d][1]
            if 0 <= px < 19 and 0 <= py < 19 and board[px][py] == color:
                continue

            cnt = 1
            dfs(i, j, d, color)

            if cnt == 5:
                # 6목 방지: 마지막점 다음 칸에 같은 돌 있으면 패스
                nx = i + dirs[d][0] * 5
                ny = j + dirs[d][1] * 5
                if 0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == color:
                    continue

                print(color)
                print(i + 1, j + 1)
                sys.exit(0)

print(0)
