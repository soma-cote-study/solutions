import sys
input = sys.stdin.readline

MAX = 2**63 - 1

A, B = input().split()

def char_to_val(c):
    if '0' <= c <= '9':
        return ord(c) - ord('0')
    return ord(c) - ord('a') + 10

def min_base(s):
    return max(char_to_val(c) for c in s) + 1

def convert(s, base):
    val = 0
    for c in s:
        v = char_to_val(c)
        if v >= base:
            return -1
        val = val * base + v
        if val > MAX:
            return -1
    return val

candidates = []

minA = min_base(A)
minB = min_base(B)

for baseA in range(minA, 37):
    valA = convert(A, baseA)
    if valA == -1:
        continue

    for baseB in range(minB, 37):
        if baseA == baseB:
            continue

        valB = convert(B, baseB)
        if valB == -1:
            continue

        if valA == valB:
            candidates.append((valA, baseA, baseB))

if len(candidates) == 0:
    print("Impossible")
elif len(candidates) > 1:
    print("Multiple")
else:
    x, a, b = candidates[0]
    print(x, a, b)
