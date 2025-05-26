def solution(babbling):
    answer = 0
    words = ['aya', 'ye', 'woo', 'ma']
    
    for babble in babbling:
        i = 0
        prev = ''
        valid = True
        while i < len(babble):
            matched = False
            for word in words:
                if babble.startswith(word, i) and word != prev:
                    i += len(word)
                    prev = word
                    matched = True
                    break
            if not matched:
                valid = False
                break
        if valid:
            answer += 1

    return answer
