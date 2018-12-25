def merge(a, b):
    '''function to merge 2 arrays'''
    
    c = []
    while len(a) > 0 and len(b) > 0:
        if a[0] < b[0]:
            c.append(a[0])
            a.remove(a[0])
        else:
            c.append(b[0])
            b.remove(b[0])
            
    if len(a) == 0:
        c += b
    else:
        c += a
            
    return c


def mergesort(arr):
    '''use mergesort to split array and then use merge fun to combine'''
    
    if len(arr) == 1 or len(arr) == 0:
        return arr
    else:
        mid = len(arr) // 2
        a = mergesort(arr[:mid])
        b = mergesort(arr[mid:])
        print(a,b, sep=" ")
        return merge(a, b)
    
    
test_list = [1,13,9,13,5,9,29]
print (mergesort(test_list))