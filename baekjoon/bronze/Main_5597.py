from sys import stdin

lst = [0]*31
result = []

for i in range(28):
    n = int( stdin.readline() )
    lst[n] = 1

for i in range(1, 31):
    if lst[i] == 0:
        result.append(i)

for i in result:
    print(i)