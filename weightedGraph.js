class WeightedGraph {
    constructor(node) {
        this._node = node
        this._routes = {}
    }

    add_route(node, weight) {
        this._routes[node] = weight
    }
}

const dallas = new WeightedGraph("Dallas")
const toronto = new WeightedGraph("Toronto")

dallas.add_route(toronto, 110)
toronto.add_route(dallas, 204)

console.log(dallas._routes[toronto])