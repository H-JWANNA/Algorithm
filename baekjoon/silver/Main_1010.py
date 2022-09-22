from sys import stdin

input = stdin.readline

def facto(num):
    fac = 1
    for i in range(2, num+1):
        fac *= i
    return fac

t = int(input())
for i in range(t):
    n, m = map(int, input().split())
    print(int(facto(m) / (facto(m-n) * facto(n))))
        