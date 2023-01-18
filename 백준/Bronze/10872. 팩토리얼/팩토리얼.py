N = int(input())
answer = 1
for i in range(1,N+1):
    if N == 0:
        answer = 1
    else:
        answer = answer * i
        
print(answer)