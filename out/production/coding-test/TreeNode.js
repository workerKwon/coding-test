class TreeNode {
    constructor(value, left_node, right_node) {
        this.value = value
        this.leftChild = left_node
        this.rightChild = right_node
    }
}

function search(value, node) {
    if(!node || node.value === value) return node
    else if(node.value < value) return search(value, node.rightChild)
    else return search(value, node.leftChild)
}

function insert(value, node) {
    if(value < node.value) {
        if(!node.leftChild) {
            node.leftChild = new TreeNode(value)
        } else {
            insert(value, node.leftChild)
        }
    } else {
        if(!node.rightChild) {
            node.rightChild = new TreeNode(value)
        } else {
            insert(value, node.rightChild)
        }
    }
}

function deleteNode(value, node) {
    if(!node) return null
    else if(value > node.value) {
        node.rightChild = deleteNode(value, node.rightChild)
        return node
    } else if (value < node.value) {
        node.leftChild = deleteNode(value, node.leftChild)
        return node
    } else if (value === node.value) {
        if(!node.leftChild) {
            return node.rightChild
        } else if(!node.rightChild) {
            return node.leftChild
        } else {
            node.rightChild = lift(node.rightChild, node) 
            return node
        }
    }
}

function lift(node, deletedNode) {
    if(node.leftChild) {
        node.leftChild = lift(node.leftChild, deleteNode)
        return node
    } else {
        deletedNode.value = node.value
        return node.rightChild
    }
}

function alphbet_sort(node) {
    if(!node) return

    alphbet_sort(node.leftChild)
    console.log(node.value)
    alphbet_sort(node.rightChild)
}

const leftNode = new TreeNode(1)
const rightNode = new TreeNode(10)
const root = new TreeNode(5, leftNode, rightNode)

console.log(search(61, root))

insert(12, root)

console.log(search(12, root))

console.log(root)

console.log(deleteNode(10, root))

console.log(deleteNode(12, root))