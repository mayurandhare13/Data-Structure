# Find all possible words in a board of characters
"""Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G','I','Z'},
                       {'U','E','K'},
                       {'Q','S','E'}};
Output:  Following words of dictionary are present
         GEEKS
         QUIZ
"""


def findUtils(words, boggle, r, c, visited, found, str):
    rows = len(boggle)
    cols = len(boggle[0])

    visited[r][c] = True

    str += boggle[r][c]

    if (str in words):
        found.add(str)

    for i in range(r-1, rows):
        for j in range(c-1, cols):
            if i >= rows or i < 0 or j >= cols or j < 0 or visited[i][j]:
                continue
            findUtils(words, boggle, i, j, visited, found, str)

    visited[r][c] = False


def findWords(words, boggle):
    rows = len(boggle)
    cols = len(boggle[0])

    visited = [[False for i in range(cols)] for j in range(rows)]

    str = ""
    found = set()
    for r in range(rows):
        for c in range(cols):
            findUtils(words, boggle, r, c, visited, found, str)

    return found


if __name__ == '__main__':
    words = {"LIFE", "FOR", "FOE", "GO", "SEEK"}
    boggle = [['G', 'I', 'Z'],
              ['L', 'E', 'F'],
              ['R', 'O', 'E']]

    found = findWords(words, boggle)
    for word in found:
        print(word)