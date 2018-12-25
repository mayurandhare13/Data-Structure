import random

class Heap(object):
    
    def __init__(self):
        self.__heap = []
        self.__last_index = -1
        
    
    def push(self, value):
        self.__last_index += 1
        if self.__last_index < len(self.__heap):
            self.__heap[self.__last_index] = value
        else:
            self.__heap.append(value)
        
        self.__shiftup(self.__last_index)
        
     
    def pop(self):
        if self.__last_index == -1:
            raise IndexError('pop from empty heap')
        
        min_val = self.__heap[0]
        self.__heap[0] = self.__heap[self.__last_index]
        self.__last_index -= 1
        self.__shiftdown(0)
        
        return min_val
     
        
    def __shiftup(self, index):
        while index > 0:
            parent_index, parent_value = self.__get_parent(index)
            
            if parent_value <= self.__heap[index]:
                break
            
            else:
                self.__heap[parent_index], self.__heap[index] = \
                self.__heap[index], self.__heap[parent_index]
                
            index = parent_index
    
    
    def __shiftdown(self, index):
        while True:
            index_val = self.__heap[index]
            
            left_child_index, left_child_val = self.__get_left_child(index, index_val)
            right_child_index, right_child_val = self.__get_right_child(index, index_val) 
            
            if index_val <= left_child_val and index_val <= right_child_val:
                break
            
            if left_child_val < right_child_val:
                new_index = left_child_index
            else:
                new_index = right_child_index
            
            self.__heap[new_index], self.__heap[index] =\
            self.__heap[index], self.__heap[new_index]
            
            index = new_index
        
    
    def __get_parent(self, index):
        if index == 0:
            return None, None
        
        parent_index = (index - 1) // 2
        return parent_index, self.__heap[parent_index]  
    
    
    def __get_left_child(self, index, default_val):
        left_child_index = 2 * index + 1
        if left_child_index > self.__last_index:
            return None, default_val
        
        return left_child_index, self.__heap[left_child_index]
    
    
    def __get_right_child(self, index, default_val):
        right_child_index = 2 * index + 2
        if right_child_index > self.__last_index:
            return None, default_val
        
        return right_child_index, self.__heap[right_child_index]  
    
    
    def __len__(self):
        return self.__last_index + 1
    
    
values = random.sample(range(100), 10)
print(values)

h = Heap()
for v in values:
    h.push(v)

while len(h) > 0:
    print(h.pop())   