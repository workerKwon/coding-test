"""
선입선출. 먼저 들어간 원소가 먼저 나온다. 대기줄을 서는것이라고 생각하면 된다. Queue

삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제() 표현
"""
from collections import deque
queue = deque()

queue.append(5)
queue.append(2)
queue.append(3)
queue.append(7)
queue.popleft()
queue.append(1)
queue.append(4)
queue.popleft()

print(queue) # 먼저 들어간 것부터 출력(최하단 요소부터)
queue.reverse()
print(queue) # 나중에 들어간 것부터 출력(최상단 요소부터)
