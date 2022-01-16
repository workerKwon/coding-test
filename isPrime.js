function is_prime(number) {
    for (let i =2 ; i < number; i++) {
        if(number % i === 0) return false
    }
    return true
}

console.log(is_prime(7))