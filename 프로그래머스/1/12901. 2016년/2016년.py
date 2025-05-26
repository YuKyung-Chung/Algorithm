def solution(a, b):
    # 윤년 기준 각 달의 일수
    month_days = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    days_of_week = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']

    # 1월 1일부터 총 일수 구하기
    total_days = sum(month_days[:a-1]) + b - 1
    
    return days_of_week[total_days % 7]