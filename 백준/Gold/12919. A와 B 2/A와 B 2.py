S = input().strip()
T = input().strip()

def dfs(word):
    if len(word) == len(S):
        return 1 if word == S else 0

    if word[0] == 'B':
        if dfs(word[1:][::-1]) == 1:
            return 1

    if word[-1] == 'A':
        if dfs(word[:-1]) == 1:
            return 1

    return 0

print(dfs(T))