class Graph {
    constructor(name) {
        this._name = name
        this._friends = []
    }

    add_friend(friend) {
        this._friends.push(friend)
    }
}

const mary = new Graph('Mary')
const peter = new Graph("Peter")
mary.add_friend(peter)
peter.add_friend(mary)
console.log(mary)