def list_sum(num_list):
    sum = 0
    for i in num_list:
        sum += i
    return sum

def list_multiply(num_list):
    multiply = 1
    for i in num_list:
        multiply *= i
    return multiply

def solution(num_list):
    answer = 0
    sum = list_sum(num_list)
    multi = list_multiply(num_list)
    
    if(multi < sum**2):
        answer = 1
    elif(multi > sum**2):
        answer = 0
    return answer

