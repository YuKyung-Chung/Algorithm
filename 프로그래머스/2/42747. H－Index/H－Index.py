from collections import Counter

def solution(citations):
    answer = 0
    more = len(citations)
    less = 0
    h = 0
    while more > less:
        more = len([x for x in citations if x >= h])
        less = len([x for x in citations if x < h])
        # print(more, less)
        if more >= h:
            h += 1
        else:
            answer = h-1
            break
    return answer