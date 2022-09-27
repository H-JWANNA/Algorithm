from sys import stdin

n = stdin.readline()
lst = list(map(int, stdin.readline().split()))

print(max(lst)*min(lst))