from sys import stdin

input = stdin.readline

m = int(input())
n = int(input())

sqrtm = int(m**(1/2))
sqrtn = int(n**(1/2))

lst = []

for i in range(m, n+1):
    if sqrtm**2 < m:
        sqrtm += 1
        
    if sqrtm**2 == i:
        lst.append(sqrtm**2)
        sqrtm += 1

if len(lst) == 0:
    print(-1)
else :
    print(sum(lst))
    print(min(lst))