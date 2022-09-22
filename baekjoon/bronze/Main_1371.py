from sys import stdin

lst1 = [0 for x in range (0,26)]

input = stdin.read().replace(" ", "").replace("\n", "")

for j in input:
    lst1[ord(j)-97] += 1

lst2 = [i for i, v in enumerate(lst1) if v == max(lst1)]

for a in lst2:
    print(chr(a+97), end="")