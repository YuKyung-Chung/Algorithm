def solution(numbers):
    answer = []
    results = set()
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            results.add(numbers[i] + numbers[j])
    answer = sorted(results)
    return answer