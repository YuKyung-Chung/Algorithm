from collections import defaultdict
def solution(genres, plays):
    answer = []
    g_dict = defaultdict(lambda: [0, []])
    
    for i, (genre, play) in enumerate(zip(genres, plays)):
        g_dict[genre][0] += play # 총 재생수
        g_dict[genre][1].append((i, play)) # 인덱스, 재생수
    
    # 장르 별 많이 재생된 순으로 정렬
    sorted_dict = sorted(g_dict.items(), key=lambda x:(x[1][0]), reverse=True)
    
    for genre, (i, play) in sorted_dict:
        sorted_dict2 = sorted(play, key=lambda x:(-x[1],x[0]))
        for i, p in sorted_dict2[:2]:
            answer.append(i)
        
    
    return answer