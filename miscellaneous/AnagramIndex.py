# Given a word and a string S, find all starting indices in S which are anagrams of word.

# For example, given that word is “ab”, and S is “abxaba”, return 0, 3, and 4.

class FreqDict:
    
    def __init__(self, s):
        self.d = {}
        for c in s:
            self.increment(c)

    def increment(self, c):
        self._create_ifNotExist(c)
        self.d[c] += 1
        self._del_ifZero(c)
    
    def decrement(self, c):
        self._create_ifNotExist(c)
        self.d[c] -= 1
        self._del_ifZero(c)

    def isEmpty(self):
        return not self.d

    def _create_ifNotExist(self, c):
        if c not in self.d.keys():
            self.d[c] = 0

    def _del_ifZero(self, c):
        if self.d[c] == 0:
            del self.d[c]

def anagram_indices(word, s):
    results = []
    freq = FreqDict(word)

    print(freq.d)

    for c in s[0:len(word)]:
        freq.decrement(c)

    print(freq.d)

    if freq.isEmpty():
        results.append(0)

    for i in range(len(word), len(s)):
        start_char, end_char = s[i - len(word)], s[i]
        freq.increment(start_char)
        freq.decrement(end_char)

        print(freq.d)

        if freq.isEmpty():
            begin_index = i - len(word) + 1
            results.append(begin_index)

    return results


if __name__ == '__main__':
    word = "ab"
    s = "abxaba"
    print(anagram_indices(word, s))