def solution(data, ext, val_ext, sort_by):
    answer = []
    info = {'code':0, 'date':1, 'maximum':2, 'remain':3}
    
    # data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후
    for d in data:
        if d[info[ext]] < val_ext:
            answer.append(d)

    # sort_by에 해당하는 값을 기준으로 오름차순으로 정렬
    answer = sorted(answer, key=lambda x: x[info[sort_by]])

    return answer