def bubbleSort(in_arr):
    for passnum in range(len(in_arr)-1, 0, -1):
        for i in range(passnum):
            if (in_arr[i] > in_arr[i+1]):
                in_arr[i], in_arr[i+1] = in_arr[i+1], in_arr[i]
                

def shortBubbleSort(in_arr):
    passnum = len(in_arr) - 1
    exchanges = True
    while(passnum > 0 and exchanges):
        exchanges = False
        for i in range(passnum):
            if(in_arr[i] > in_arr[i+1]):
                exchanges = True
                in_arr[i], in_arr[i+1] = in_arr[i+1], in_arr[i]
        passnum -= 1
                
nlist = [20, 30, 40, 90, 50, 60, 70, 80, 100, 110]
shortBubbleSort(nlist)
print(nlist)