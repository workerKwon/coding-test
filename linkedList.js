class Node {
    get data() {
        return this._data
    }

    set data(data) {
        this._data = data
    }

    get next_node() {
        return this._next_node
    }

    set next_node(next_node) {
        this._next_node = next_node
    }

    constructor(data) {
        this._data = data
    }
}

class LinkedList {
    get first_node() {
        return this._first_node
    }

    set first_node(first_node) {
        this._first_node = first_node
    }

    constructor(first_node) {
        this._first_node = first_node
    }

    read(index) {
        let current_node = this._first_node
        let current_index = 0

        while( current_index < index) {
            current_node = current_node._next_node
            current_index += 1

            if(!current_node) return null
        }

        return current_node._data
    }
}

const node1 = new Node("one")
const node2 = new Node("two")
node1._next_node = node2
const node3 = new Node("three")
node2._next_node = node3
const node4 = new Node('four')
node3._next_node = node4

const list = new LinkedList(node1)

console.log(list.read(0))