import sys
input = sys.stdin.readline

def can_fold(s):
    if len(s) == 1:
        return True

    mid = len(s) // 2
    left = s[:mid]
    right = s[mid+1:]

    rev_right = ""

    for c in reversed(right):
        if c == '0':
            rev_right += '1'
        else:
            rev_right += '0'


    if left != rev_right:
        return False

    return can_fold(left)

T = int(input())
for _ in range(T):
    s = input().strip()
    print("YES" if can_fold(s) else "NO")
