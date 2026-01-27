import sys
input = sys.stdin.readline

S, E, Q = input().split()

def to_min(t):
    h, m = map(int, t.split(":"))
    return h * 60 + m

S = to_min(S)
E = to_min(E)
Q = to_min(Q)

attendStudent = set()
answer = 0

while True:
    line = input().rstrip()
    if not line:
        break

    t, name = line.split()
    t = to_min(t)

    if t <= S:
        attendStudent.add(name)
    elif E <= t <= Q:
        if name in attendStudent:
            answer += 1
            attendStudent.remove(name)

print(answer)
