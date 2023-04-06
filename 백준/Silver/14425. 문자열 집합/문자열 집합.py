import sys
read = sys.stdin.readline

class Node(object):
    def __init__(self, isEnd):
        self.isEnd = isEnd
        self.childNode = {}

class Trie(object):
    def __init__(self):
        self.parent = Node(None)

    def insert(self, string):
        nowNode = self.parent
        length = 0
        for char in string:
            if char not in nowNode.childNode:
                nowNode.childNode[char] = Node(char)
            nowNode = nowNode.childNode[char]
            length += 1
            if length == len(string):
                nowNode.isEnd = True

    def search(self, string):
        nowNode = self.parent
        length = 0
        for char in string:
            if char in nowNode.childNode:
                nowNode = nowNode.childNode[char]
                length += 1
                if length == len(string) and nowNode.isEnd == True:
                    return True
            else:
                return False
        return False

n, m = map(int, read().split())
trie = Trie()

for _ in range(n):
    word = read().strip()
    trie.insert(word)

answer = 0
for _ in range(m):
    word = read().strip()
    if trie.search(word):
        answer += 1

print(answer)