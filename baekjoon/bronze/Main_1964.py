from sys import stdin

n = int( stdin.readline() )

# 1단계 : 5
# 2단계 : 5 + 7
# 3단계 : 5 + 7 + 10
# 4단계 : 5 + 7 + 10 + 13
# 5단계 : 5 + 7 + 10 + 13 + 16

dot = 5

for i in range(n - 1):
    dot += (7 + 3*i)

print(dot % 45678)