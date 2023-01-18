a=int(input())
b=int(input())

if(-1000<=a and a<=1000 and a != 0 and -1000<=b and b<=1000 and b != 0):
    if(a>0 and b>0):
        print("1")
    elif(a<0 and b>0):
        print("2")
    elif(a<0 and b<0):
        print("3")
    elif(a>0 and b<0):
        print("4")
else:
    print("-1000과 1000사이의 값 중 0이 아닌 값을 입력하세요.")