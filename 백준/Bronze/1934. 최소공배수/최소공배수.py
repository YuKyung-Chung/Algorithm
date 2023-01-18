import sys
N = int(sys.stdin.readline())

for i in range(N):
    a,b = map(int,sys.stdin.readline().split())
    aa,bb = a,b
    
    while a%b != 0 :
        a,b = b,a%b
        
    print(aa*bb//b)