def solution(s, n):
    answer = ''
    for char in s:
        if char.isupper(): #대문자인 경우
            answer += chr((ord(char) - ord('A') + n) % 26 + ord('A'))
        elif char.islower(): #소문자
            answer += chr((ord(char) - ord('a') + n) % 26 + ord('a'))
        else: #공백
            answer += char
    return answer