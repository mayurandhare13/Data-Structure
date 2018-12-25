class HashTable(object):
    
    def __init__(self):
        self.table = [None]*100000
    
    def store(self, string):
        hv = self.calculate_hash_value(string)
        if hv != -1:
            if self.table[hv] is not None:
                self.table[hv].append(string)
            else:
                self.table[hv] = [string]
                
    def lookup(self, string):
        hv = self.calculate_hash_value(string)
        if hv != -1:
            if self.table[hv] is not None:
                if string in self.table[hv]:
                    return hv
        return -1
        
    def calculate_hash_value(self, string):
        if string:
            hash_value = ord(string[0]) * 100 + ord(string[1])
            return hash_value
        return -1   
    
# Setup
hash_table = HashTable()

# Test calculate_hash_value
# Should be 7765
print(hash_table.calculate_hash_value('MAYUR'))

# Test lookup edge case
# Should be -1
print(hash_table.lookup('MAYURI'))

# Test store
hash_table.store('MAYUR')
# Should be 7765
print(hash_table.lookup('MAYUR'))

# Test store edge case
hash_table.store('MAYURI')
# Should be 7765
print(hash_table.lookup('MAYURI'))