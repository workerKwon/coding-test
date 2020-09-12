n = int(input())
arr = []
for _ in range(n):
    input_data = input().split()
    arr.append((input_data[0], input_data[1]))

arr.sort(key=lambda score: score[1])

for i in arr:
    print(i[0], end=' ')
