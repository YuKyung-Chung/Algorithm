def solution(name, yearning, photo):
    answer = []
    y_dict = {}
    for n in range(len(name)):
        y_dict[name[n]] = yearning[n]

    for p in photo:
        score = 0
        for person in p:
            if person in y_dict:
                score += y_dict[person]
                
        answer.append(score)
    return answer