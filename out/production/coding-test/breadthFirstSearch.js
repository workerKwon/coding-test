class PersonGraph {
    constructor(name) {
        this._name = name
        this._friends = []
        this._visited = false
    }

    add_friend(friend) {
        this._friends.push(friend)
    }

    display_network() {
        const to_reset = [this]
        const queue = [this]
        this._visited = true

        while(queue.length) {
            const current_vertex = queue.shift()
            console.log(current_vertex._name)

            for(let friend of current_vertex._friends) {
                if(!friend._visited) {
                    to_reset.push(friend)
                    queue.push(friend)
                    friend._visited = true
                }
            }
        }

        for(let node of to_reset) {
            node._visited = false
        }
    }
}

const alice = new PersonGraph("Alice")
const bob = new PersonGraph("Bob")
const cynthia = new PersonGraph("Cynthia")
alice.add_friend(bob)
bob.add_friend(alice)
bob.add_friend(cynthia)
cynthia.add_friend(bob)

alice.display_network()