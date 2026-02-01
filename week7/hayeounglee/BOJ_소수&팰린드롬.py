import math

def is_prime(x):
    if x < 2:
        return False
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True

def is_palindrome(x):
    s = str(x)
    return s == s[::-1]

N = int(input())

num = N
while True:
    if is_prime(num) and is_palindrome(num):
        print(num)
        break
    num += 1
