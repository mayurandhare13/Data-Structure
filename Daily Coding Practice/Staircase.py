'''
This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
'''
def staircase(n , X):
    cache = [0] * (n+1)
    cache[0] = 1
    for i in range(1, n+1):
        cache[i] += sum(cache[i-x] for x in X if i - x >= 0)

    return cache[n]


X = [1, 3, 5]
n = 10
print(staircase(n, X))