from sys import stdin

n, m = map(int, stdin.readline().split())

width = abs((((n-1)//4)+1) - (((m-1)//4)+1))
height = abs(((n-1)%4) - ((m-1)%4))

print(width + height)