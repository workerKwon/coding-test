class PrintManager {
    constructor() {
        this._queue = []
    }

    queue_print_job(document) {
        this._queue.push(document)
    }

    run() {
        while(this._queue.length) {
            this.print(this._queue.shift())
        }
    }

    print(document) {
        console.log(document)
    }
}

const print_manager = new PrintManager;
print_manager.queue_print_job("first doc")
print_manager.queue_print_job("second doc")
print_manager.queue_print_job("third doc")
print_manager.run()
