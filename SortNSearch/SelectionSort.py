def selection_sort(alist):
    for i in range(len(alist)):

        # find min element in remaining
        minPosition = i
        for j in range(i+1, len(alist)):
            if alist[minPosition] > alist[j]:
                minPosition = j
        # Swap the found minimum element with minPosition
        alist[i], alist[minPosition] = alist[minPosition], alist[i]
    
    return alist

test_list = [1,13,9,21,15,19,29]
print(selection_sort(test_list))