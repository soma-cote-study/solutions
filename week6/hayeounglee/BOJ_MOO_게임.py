N = int(input())

length = [3]
k = 0

while length[k] < N:
    k += 1
    length.append(length[k-1] * 2 + (k + 3))

def solve(k, n):
    if k == 0:
        return "moo"[n-1]

    left = length[k-1]
    middle = k + 3

    if n <= left:
        return solve(k-1, n)
    elif n <= left + middle:
        if n == left + 1:
            return 'm'
        else:
            return 'o'
    else:
        return solve(k-1, n - left - middle)

print(solve(k, N))
