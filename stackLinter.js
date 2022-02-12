class Linter {
    get error() {
      return this._error
    };
  
    constructor() {
      this._stack = []
    };
  
    lint(text) {
      [...text].forEach((char, index) => {
        if (this.opening_brace(char)) {
          this._stack.push(char)
        } else if (this.closing_brace(char)) {
          if (this.closes_most_recent_opening_brace(char)) {
            this._stack.pop()
            console.log("stack", this._stack)
          } else {
            this._error = `Incorrect closing brace: ${char} at index ${index}`;
            return
          }
        }
      });
  
      if (this._stack.any) {
        this._error = `${this._stack.last} does not have a closing brace`
      }
    };
  
    opening_brace(char) {
      return ["(", "[", "{"].includes(char)
    };
  
    closing_brace(char) {
      return [")", "]", "}"].includes(char)
    };
  
    opening_brace_of(char) {
      return { ")":"(", "]" : "[", "}" : "{"}[char]
    };
  
    most_recent_opening_brace() {
      return this._stack[this._stack.length - 1]
    };
  
    closes_most_recent_opening_brace(char) {
        console.log(this.opening_brace_of(char) == this.most_recent_opening_brace())
      return this.opening_brace_of(char) == this.most_recent_opening_brace
    }
  };
  
  let linter = new Linter;
  linter.lint("( var x = { y: [1, 2, 3] } )");
  console.log(linter.error)