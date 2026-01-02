import sys
from collections import deque

input = sys.stdin.readline


def operate():
    global reverse_flag
    reverse_flag = False

    for op in operation:
        if op == 'D':
            if len(queue) == 0: # if not queue:
                print("error")
                return False
            if reverse_flag:
                queue.pop()
            else:
                queue.popleft()
        if op == 'R':
            reverse_flag = not reverse_flag
    return True


T = int(input())
while T:
    operation = input().strip()        # 함수 문자열
    n = int(input().strip())       # 배열 길이
    num = input().strip()      # "[1,2,3,4]" 형태

    # 문자열 배열을 deque로
    if n == 0:
        queue = deque()
    else:
        queue = deque(num[1:-1].split(","))


    if operate():
        if reverse_flag:
            queue.reverse()
        print("[" + ",".join(queue) + "]")

    T -= 1
