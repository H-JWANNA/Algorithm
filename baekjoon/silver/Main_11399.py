from sys import stdin

input = stdin.readline

n = int(input())
lst = list(map(int, input().split()))
lst.sort()

sum = 0

for i, x in enumerate(lst):
    sum += x * (n - i)

print(sum)