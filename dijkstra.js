class WeightedGraph {
    constructor(_name) {
        this.name = _name
        this.routes = new Map() // js는 Map객체를 사용해야 Object를 key로 사용할 수 있다.
    }

    add_route(node, weight) {
        this.routes.set(node, weight)
    }
}

const atlanta = new WeightedGraph('Atlanta')
const boston = new WeightedGraph('Boston')
const chicago = new WeightedGraph('Chicago')
const denver = new WeightedGraph('Denver')
const elpaso = new WeightedGraph('Elpaso')
atlanta.add_route(boston, 100)
atlanta.add_route(denver, 160)
boston.add_route(chicago, 120)
boston.add_route(denver, 180)
chicago.add_route(elpaso, 80)
denver.add_route(chicago, 40)
denver.add_route(elpaso, 140)

// function dijkstra(start_node, other_nodes) {
//     // 결과 테이블. 각 노드별로 시작노드로부터 걸리는 무게와 노드에 도착하기 직전의 노드를 세팅. 처음에는 아무것도 없음.
//     let routes_from_start = new Map();
//     routes_from_start.set(start_node, [0, start_node])
//     other_nodes.forEach(node => {
//         routes_from_start.set(node, [Infinity, null])
//     });

//     // 방문한 노드
//     const visited_nodes = []

//     // 시작노드를 현재 노드로 잡고 시작한다.
//     let current_node = start_node

//     // 현재노드가 존재한다면 계속 반복
//     while (current_node) {
//         // 현재노드를 방문한 노드로 기록한다.
//         visited_nodes.push(current_node)

//         // 현재 노드에 인접한 노드와 무게를 결과 테이블에 있는 시작노드로부터 걸리는 무게와 비교해서 더 적은 무게로 변경한다.
//         for(const [node, weight] of current_node.routes) {
//             if(routes_from_start.get(node)[0] > weight + routes_from_start.get(current_node)[0]) {
//                 routes_from_start.set(node, [weight + routes_from_start.get(current_node)[0], current_node])
//             }
//         }

//         // 결과 테이블 변경이 끝났으면 현재 테이블을 null로 변경한다.
//         current_node = null
//         let cheapest_route_from_current_node = Infinity

//         // 결과 테이블의 각 노드와 (최소 무게, 직전 노드) 정보를 이용해서 다음으로 (현재 노드가 될) 방문할 노드를 결정한다.
//         for(const [node, weight_from_start_by_node] of routes_from_start) {
//             // 반복문으로 방문하지 않은 가장 가벼운 무게의 노드를 찾는다. 
//             if(weight_from_start_by_node[0] < cheapest_route_from_current_node && !visited_nodes.includes(node)) {
//                 cheapest_route_from_current_node = weight_from_start_by_node[0]
//                 current_node = node
//             }
//         }
//     } // 모두 방문한 노드가 된다면 current_node 가 null이 되어 반복문이 끝난다.

//     // 결과 테이블을 반환한다.
//     return routes_from_start
// }



// 직전노드를 사용하지 않아도 나오긴 한다.
function dijkstra(start_node, other_nodes) {
    // 결과 테이블. 각 노드별로 시작노드로부터 걸리는 무게와 노드에 도착하기 직전의 노드를 세팅. 처음에는 아무것도 없음.
    let routes_from_start = new Map();
    routes_from_start.set(start_node, 0)
    other_nodes.forEach(node => {
        routes_from_start.set(node, Infinity)
    });

    // 방문한 노드
    const visited_nodes = []

    // 시작노드를 현재 노드로 잡고 시작한다.
    let current_node = start_node

    // 현재노드가 존재한다면 계속 반복
    while (current_node) {
        // 현재노드를 방문한 노드로 기록한다.
        visited_nodes.push(current_node)

        // 현재 노드에 인접한 노드와 무게를 결과 테이블에 있는 시작노드로부터 걸리는 무게와 비교해서 더 적은 무게로 변경한다.
        for(const [node, weight] of current_node.routes) {
            if(routes_from_start.get(node) > weight + routes_from_start.get(current_node)) {
                routes_from_start.set(node, weight + routes_from_start.get(current_node))
            }
        }

        // 결과 테이블 변경이 끝났으면 현재 테이블을 null로 변경한다.
        current_node = null
        let cheapest_route_from_current_node = Infinity

        // 결과 테이블의 각 노드와 (최소 무게, 직전 노드) 정보를 이용해서 다음으로 (현재 노드가 될) 방문할 노드를 결정한다.
        for(const [node, weight_from_start_by_node] of routes_from_start) {
            // 반복문으로 방문하지 않은 가장 가벼운 무게의 노드를 찾는다. 
            if(weight_from_start_by_node < cheapest_route_from_current_node && !visited_nodes.includes(node)) {
                cheapest_route_from_current_node = weight_from_start_by_node
                current_node = node
            }
        }
    } // 모두 방문한 노드가 된다면 current_node 가 null이 되어 반복문이 끝난다.

    // 결과 테이블을 반환한다.
    return routes_from_start
}

const routes = dijkstra(atlanta, [boston, chicago, denver, elpaso])
for(const [node, route_info_by_node] of routes) {
    console.log(`${node.name} : ${route_info_by_node}`)
}