class Node(object):
    def __init__(self,x):
        self.value = x
        self.left = None
        self.right = None

# O(n)
def is_unival(root):  
    if root == None:
        return True
    if root.left != None and root.left.value != root.value:
        return False
    if root.right != None and root.right.value != root.value:
        return False
    if is_unival(root.left) and is_unival(root.right):
        return True

    return False

# this will run --> O(n^2)
def count_univals(root):
    if root == None:
        return 0    

    total_count = count_univals(root.left) + count_univals(root.right)

    if is_unival(root):
        total_count += 1
    
    return total_count


# Optimize solution o(n)
def count_univals2(root):
    total_count, is_unival = countHelper(root)
    return total_count


def countHelper(root):
    if root == None:
        return (0, True)
    
    left_count, is_left_unival = countHelper(root.left)
    right_count, is_right_unival = countHelper(root.right)

    is_unival = True
    if not is_left_unival or not is_right_unival:
        is_unival = False
    if root.left != None and root.left.value != root.value:
        is_unival = False
    if root.right != None and root.right.value != root.value:
        is_unival = False

    if is_unival:
        return (left_count + right_count + 1, True)
    else:
        return (left_count + right_count, False)



        #   2
        #  / \
        # 1   2
        #    / \
        #    2  2
        #        \
        #         2
if __name__ == "__main__":
    n1 = Node(2)
    n2 = Node(1)
    n3 = Node(2)
    n4 = Node(2)
    n5 = Node(2)
    n6 = Node(3)
    n1.left = n2
    n1.right = n3
    n3.left = n4
    n3.right = n5
    n5.right = n6
    print(count_univals2(n1))