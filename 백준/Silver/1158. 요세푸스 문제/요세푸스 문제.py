N,K = map(int,input().split())
answer = []
people = [i for i in range(1,N+1)]
num = 0
for i in range(N):
    num += (K-1)
    if num >= len(people):
        num = num % len(people)
    answer.append(str(people[num]))
    people.pop(num)
    
        
print("<",", ".join(answer),">", sep='')