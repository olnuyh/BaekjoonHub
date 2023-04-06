import sys
read = sys.stdin.readline

n = int(read())
tree = {}

for _ in range(n):
    root, left, right = read().split()
    tree[root] = [left, right]

def preorder(nowNode): 
    if nowNode == '.':
        return
    print(nowNode, end = '')
    preorder(tree[nowNode][0])
    preorder(tree[nowNode][1])

def inorder(nowNode):
    if nowNode == '.':
        return
    inorder(tree[nowNode][0])
    print(nowNode, end = '')
    inorder(tree[nowNode][1])

def postorder(nowNode):
    if nowNode == '.':
        return
    postorder(tree[nowNode][0])
    postorder(tree[nowNode][1])
    print(nowNode, end = '')

preorder('A')
print()
inorder('A')
print()
postorder('A')