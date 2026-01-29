import sys
input = sys.stdin.readline

N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

# (N+1)x(M+1) 누적합 배열 생성 (0번째 행/열은 0으로 남겨둠)
psum = [[0]*(M+1) for _ in range(N+1)]

# 누적합
for i in range(1, N+1):
    for j in range(1, M+1):
        psum[i][j] = (
                arr[i-1][j-1]
                + psum[i-1][j]
                + psum[i][j-1]
                - psum[i-1][j-1]
        )

T = int(input())

for _ in range(T):
    answer = 0
    x1, y1, x2, y2 = map(int, input().split())
    answer = (
            psum[x2][y2]
            - psum[x1-1][y2]
            - psum[x2][y1-1]
            + psum[x1-1][y1-1]
    )
    print(answer)

