class Node {
    get data() {
        return this._data
    }
    set data(data) {
        this._data = data
    }

    get previous_node() {
        return this._previous_node
    }
    set previous_node(previous_node) {
        this._previous_node = previous_node
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

class DoublyLinkedList {
    get first_node() {
        return this._first_node
    }
    set first_node(first_node) {
        this._first_node = first_node
    }

    get last_node() {
        return this._last_node
    }
    set last_node(last_node) {
        this._last_node = last_node
    }

    constructor(first_node= null, last_node = null) {
        this._first_node = first_node
        this._last_node = last_node
    }

    insert_at_end(value) {
        const new_node = new Node(value)

        if(!this.first_node) {
            this._first_node = new_node
            this._last_node = new_node
        } else {
            this._last_node._next_node = new_node
            new_node._previous_node = this._last_node
            this._last_node = new_node
        }
    }

    remove_from_front() {
        const removed_node = this._first_node
        this._first_node = this._first_node._next_node
        return removed_node
    }
}

class Queue {
    get queue() {
        return this._queue
    }
    set queue(queue) {
        this._queue = queue
    }

    constructor() {
        this._queue = new DoublyLinkedList()
    }

    enque(value) {
        this._queue.insert_at_end(value)
    }

    deque() {
        const removed_node = this._queue.remove_from_front()
        return removed_node._data
    }

    tail() {
        return this._queue._last_node._data
    }

    head() {
        return this._queue._first_node._data
    }
}

let doublyLinkedListQueue = new Queue()
doublyLinkedListQueue.enque(1)
doublyLinkedListQueue.enque(2)
doublyLinkedListQueue.enque(3)
doublyLinkedListQueue.enque(4)
doublyLinkedListQueue.enque(5)

console.log('tail : ', doublyLinkedListQueue.tail())
console.log('removed data : ', doublyLinkedListQueue.deque())
console.log('head : ',doublyLinkedListQueue.head())