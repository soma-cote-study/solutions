from collections import deque

def explode(board, R, C):
    # 전체 폭탄 설치
    new_board = [['O'] * C for _ in range(R)]

    for x in range(R):
        for y in range(C):
            if board[x][y] == 'O':
                new_board[x][y] = '.'
                for dx, dy in [(-1,0),(1,0),(0,-1),(0,1)]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < R and 0 <= ny < C:
                        new_board[nx][ny] = '.'
    return new_board

R, C, N = map(int, input().split())
board = [list(input().rstrip()) for _ in range(R)]

if N == 1:
    answer = board

elif N % 2 == 0:
    answer = [['O'] * C for _ in range(R)]

else:
    # 3초 상태
    first = explode(board, R, C)
    # 5초 상태
    second = explode(first, R, C)

    if N % 4 == 3:
        answer = first
    else:  # N % 4 == 1
        answer = second

for row in answer:
    print(''.join(row))
