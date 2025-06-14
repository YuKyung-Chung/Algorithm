def solution(numbers):
    answer = ''
    sorted_numbers = []
    # 문자열로 변환 + 비교 자리수 늘리기
    sorted_numbers = sorted(numbers, key=lambda x:str(x)*1000, reverse=True)
    
    answer += ''.join(str(num) for num in sorted_numbers)
    
    return '0' if answer[0] == '0' else answer