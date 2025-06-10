def solution(clothes):
    answer = 0
    #종류 별 아이템 이름 모으기
    dict = {}
    
    for name, kind in clothes:
        # kind가 없으면 빈 리스트 생성, 있으면 기존 리스트 반환
        dict.setdefault(kind, []).append(name)
        
    # 입지않는 경우 포함 곱셈
    total = 1
    for count in dict.values():
        total *= len(count)+1
    
    # 아무것도 안입는 경우 제외
    answer = total -1
    return answer