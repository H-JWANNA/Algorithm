from sys import stdin

def y(list):
    price = 0
    for i in list:
        i += 1
        time = i // 30
        if i%30 != 0:
            time += 1
        price += (time * 10)
    return price

def m(list):
    price = 0
    for i in list:
        i += 1
        time = i // 60
        if i%60 != 0:
            time += 1
        price += (time * 15)
    return price

n = stdin.readline()
lst = list(map(int, stdin.readline().split()))

if y(lst) == m(lst):
    print("Y M", y(lst))
elif y(lst) > m(lst):
    print("M", m(lst))
else:
    print("Y", y(lst))