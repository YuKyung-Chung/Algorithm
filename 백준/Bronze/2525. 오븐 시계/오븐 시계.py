A,B=map(int,input().split())
C=int(input())

if B+C >= 60:
    a,b=divmod(B+C,60)
    A,B=(A+a,b)
    if A>23:
        print(A-24,B)
    else:
        print(A,B)
else:
    print(A,B+C)