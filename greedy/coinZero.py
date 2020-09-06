n, k = map(int, input().split())
a = []
for i in range(n):
    m = int(input())
    a.append(m)

a.sort(reverse=True)
count = 0
for i in a:
    count += k // i
    k %= i
    if k == 0:
        break

print(count)
