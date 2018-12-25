def binarySearch(input_array, value):
    low = 0
    high = len(input_array)
    
    while low <= high:
        mid = (low + high) // 2
        if(input_array[mid] == value):
            print("assuming index starts with 1")
            return mid+1
        elif (input_array[mid] < value):
            low = mid + 1
        else:
            high = mid - 1
    return -1

test_list = [1,3,9,11,15,19,29]
test_val1 = 1
test_val2 = 15

print (binarySearch(test_list, test_val1))
print (binarySearch(test_list, test_val2))