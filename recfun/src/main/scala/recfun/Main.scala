package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if(c == 0) 1
      else if(c > r) 0
      else pascal(c-1,r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = _balance(chars, 0)
    
    def _balance(chars: List[Char], open: Int): Boolean = {
      if (open < 0) false //the balance cannot go below 0.. you closed more than you opened!
      else if(chars.isEmpty) open == 0 //check the balance is 0 at the end
      else if(chars.head == '(') _balance(chars.tail, open + 1)
      else if(chars.head == ')') _balance(chars.tail, open - 1)
      else _balance(chars.tail, open)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (coins.isEmpty || money < 0) 0
      else 
        countChange(money - coins.head, coins) + /* use first coin of the list; can use it again */
          countChange(money, coins.tail) /* no more current coin; go on to the next ones */
      }
  }
