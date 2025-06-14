def solution(array, commands):
    answer = []
    
    for command in commands:
        sorted_array = []
        for i in range(command[0]-1, command[1]):
            sorted_array.append(array[i])
        sorted_array.sort()
        answer.append(sorted_array[command[2]-1])
    return answer