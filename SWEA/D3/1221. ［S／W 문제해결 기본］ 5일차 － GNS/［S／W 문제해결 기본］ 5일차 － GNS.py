T = int(input())
for test_case in range(1,T+1):
    sign, num = input().split()
    arr = list(input().split())

    word_dict = {
        'ZRO':0,
        'ONE':1,
        'TWO':2,
        'THR':3,
        'FOR':4,
        'FIV':5,
        'SIX':6,
        'SVN':7,
        'EGT':8,
        'NIN':9
    }

    arr.sort(key = lambda x:word_dict[x])
    print('#'+str(test_case), ' '.join(arr))