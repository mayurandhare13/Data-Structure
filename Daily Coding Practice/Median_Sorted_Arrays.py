# find the median of two sorted array in log time


def find_median(arr1, arr2):
    total_len = len(arr1) + len(arr2)
    if total_len % 2 == 0:
        return (find_Kth(total_len // 2, arr1, arr2) +
                find_Kth((total_len // 2) - 1, arr1, arr2)) / 2

    return find_Kth(total_len // 2, arr1, arr2)


def find_Kth(k, arr1, arr2):
    
    if len(arr1) == 0:
        return arr2[k]

    if len(arr2) == 0:
        return arr1[k]

    mid1 = len(arr1) // 2
    mid2 = len(arr2) // 2
    if k > (mid1 + mid2):
        if arr1[mid1] > arr2[mid2]:
            return find_Kth(k - mid2 - 1, arr1, arr2[mid2 + 1:])
        else:
            return find_Kth(k - mid1 - 1, arr1[mid1 + 1:], arr2)
    else:
        if arr1[mid1] > arr2[mid2]:
            return find_Kth(k, arr1[:mid1], arr2)
        else:
            return find_Kth(k, arr1, arr2[:mid2])


print(find_median([1, 3], [2]))
print(find_median([1, 3, 4], [1, 2, 3]))