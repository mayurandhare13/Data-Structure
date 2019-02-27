'''
Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
    The "largest sum of non-adjacent numbers" is the sum of any subset of non-contiguous elements.
'''

def max_sum(arr, i):
    if i == 0:
        return arr[0]
    if i == 1:
        return max(arr[0], arr[1])
    
    return max(arr[i] + max_sum(arr, i-2), max_sum(arr, i-1))


# time: O(n), space: O(n)
def max_sum_opt(arr, i):
    global mem
    if i == 0:
        return arr[0]
    if i == 1:
        return max(arr[0], arr[1])
    if mem[i]:
        return mem[i]
    
    mem[i] = max(arr[i] + max_sum_opt(arr, i - 2), max_sum_opt(arr, i - 1))
    return mem[i]




if __name__ == "__main__":
    arr = [2, 4, 6, 2, 5]
    mem = [None] * (len(arr))
    print(max_sum_opt(arr, len(arr) - 1))