def solution(genres, plays):
    # 1) 장르별 노래 목록 구축
    song_dict = {}
    for i, genre in enumerate(genres):
        song_dict.setdefault(genre, []).append((i, plays[i]))
    
    # 2) 장르별 총 재생 횟수 계산
    #    (sum of plays for each (idx, play) tuple)
    genre_totals = {
        genre: sum(play for _, play in lst)
        for genre, lst in song_dict.items()
    }
    
    # 3) 장르를 총 재생 횟수 내림차순 정렬
    sorted_genres = sorted(
        genre_totals,
        key=lambda g: genre_totals[g],
        reverse=True
    )
    
    answer = []
    # 4) 각 장르에서 상위 2곡씩 뽑아 answer에 추가
    for genre in sorted_genres:
        # (i, play)를 재생횟수 내림차순, i 오름차순으로 정렬
        songs = sorted(
            song_dict[genre],
            key=lambda x: (-x[1], x[0])
        )
        # 최대 2개 인덱스만 뽑아서 answer에 붙이기
        answer.extend(idx for idx, _ in songs[:2])
    
    return answer
