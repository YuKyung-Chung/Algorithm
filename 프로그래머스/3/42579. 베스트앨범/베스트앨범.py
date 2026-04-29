from collections import defaultdict
def solution(genres, plays):
    answer = []
    g_dict = defaultdict(lambda: [0, []])
    
    for i, (g, p) in enumerate(zip(genres, plays)):
        g_dict[g][0] += p # 총 재생수
        g_dict[g][1].append((i,p)) # (인덱스, 재생수)
    
    # 속한 노래가 많이 재생된 장르 먼저 수록
    sorted_genres = sorted(g_dict.items(), key=lambda x: x[1][0], reverse = True)
    print(sorted_genres)
    for genre, (total, songs) in sorted_genres:
        # 장르 내에서 많이 재생된 노래 먼저 수록
        # 장르 내에서 재생 횟수 같은 노래 중에서 고유 번호 낮은 노래 먼저 수록
        sorted_songs = sorted(songs, key=lambda x:(-x[1], x[0]))
    
        answer += [i for i, p in sorted_songs[:2]]
    
    
#     print(g_dict)
    return answer