def solution(today, terms, privacies):
    answer = []

    # 1. terms → dict로 변환
    term_dict = {}
    for t in terms:
        kind, months = t.split()
        term_dict[kind] = int(months)

    # 2. 날짜를 '일수'로 바꿔서 비교
    def to_days(date_str):
        y, m, d = map(int, date_str.split('.'))
        return y * 12 * 28 + m * 28 + d

    today_days = to_days(today)

    # 3. 각 개인정보 검사
    for i, p in enumerate(privacies):
        date_str, kind = p.split()
        expire_days = to_days(date_str) + term_dict[kind] * 28

        if expire_days <= today_days:
            answer.append(i + 1)

    return answer
