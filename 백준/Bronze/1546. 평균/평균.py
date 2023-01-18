a = int(input())
b = list(map(int, input().split()))
max_score = max(b)

new_list = []
for score in b :
    new_list.append(score/max_score*100)
    
test_avg = sum(new_list)/a
print(test_avg)