T = int(input())
for test_case in range(1, T + 1):
    str1 = input().strip()
    str2 = input().strip()

    count = {}

    # str1에 있는 문자만 딕셔너리에 등록
    for char in str1:
        count[char] = 0

    # str2를 순회하며 개수 세기
    for char in str2:
        if char in count:
            count[char] += 1

    answer = max(count.values())
    print('#'+str(test_case), answer)