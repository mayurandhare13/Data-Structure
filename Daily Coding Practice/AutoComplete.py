'''
This problem was asked by Twitter.
Implement an autocomplete system. That is, given a query string s and a set of
all possible query strings, return all strings in the set that have s as a prefix.
For example, given the query string de and the set of strings [dog, deer, deal],
return [deer, deal].
Hint: Try preprocessing the dictionary into a more efficient data structure to
speed up queries.
'''

from collections import defaultdict

class Trie_Node(object):

    def __init__(self, char = None):
        self.char = char
        self.children = defaultdict(Trie_Node)
        self.end_of_word = False


def add(trie_node, word):
    cur_node = trie_node
    for char in word:
        if char in cur_node.children:
            cur_node = cur_node.children[char]
        else:
            new_node = Trie_Node(char)
            cur_node.children[char] = new_node
            cur_node = new_node
    cur_node.end_of_word = True


'''
Args:
    trie_root(Trie_Node): the root of the Trie tree
    pattern(string): the query string for autocomplete
Returns:
    list: a list of possible results
'''
def search(trie_node, pattern):
    cur_node = trie_node
    res = list()
    for char in pattern:
        if char in cur_node.children:   # able to auto-complete
            cur_node = cur_node.children[char]
            res.append(char)
        else:
            return []
    
    prefix = ''.join(res[:-1])
    suffix = build_str(cur_node)    # recursively find suffix
    return [prefix + item for item in suffix]

'''
Args:
    trie_node(Trie_Node): the node in the Trie that deeper than the pattern
Returns:
    list: a list of sub_string of possible suffix
'''
def build_str(trie_node):
    if trie_node.end_of_word:
        return [trie_node.char]
    
    sub_string = []
    for key, val in trie_node.children.items():
        sub_string.extend(build_str(val))

    sub_string = [trie_node.char + item for item in sub_string]

    return sub_string


def main():
    root = Trie_Node('*')
    str_list = ['dog', 'deer', 'deel', 'deat', 'dealete', 'deassase']
    for word in str_list:
        add(root, word)
    print(search(root, 'dea'))


if __name__ == "__main__":
    main()
