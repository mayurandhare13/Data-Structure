import heapq

lst = [1, 16, 3, 39, 26, 4, 8, 16]
heapq.heapify(lst)
heapq.heappush(lst, 13)

while len(lst) > 0:
    print(heapq.heappop(lst))