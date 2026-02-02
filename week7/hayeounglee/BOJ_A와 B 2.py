import sys

S = input().strip()
T = input().strip()

def dfs(word):
    if len(word) == len(S):
        return word == S

    # 뒤가 A면 제거
    if word[-1] == 'A':
        if dfs(word[:-1]):
            return True

    # 앞이 B면 제거 후 뒤집기
    if word[0] == 'B':
        new_word = word[1:][::-1]
        if dfs(new_word):
            return True

    return False

print(1 if dfs(T) else 0)
