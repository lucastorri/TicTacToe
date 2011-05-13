import org.scalatest.{FunSuite, BeforeAndAfterEach}
import org.scalatest.matchers.ShouldMatchers
import some.pack.{TicTacToe, Mark, InvalidSquareException, AlreadyMarkedException}
import some.pack.Mark._

//Fun for Functional, not as in Funny
class ThirdTicTacToeFunSuiteTest extends FunSuite with ShouldMatchers with BeforeAndAfterEach {

  private var ttt: TicTacToe = _
  override def beforeEach() { ttt = new TicTacToe }

  test("the game should not start finished") {
    ttt should not be ('finished)
    ttt.winner should be (Mark.`_`)
  }

  test("first player should be X") {
    ttt.currentPlayer should be (X)
  }

  test("second player should be O") {
    ttt.mark(0,0)
    ttt.currentPlayer should be (O)
  }

  test("players should be able to mark the squares") {
    ttt.mark(0, 0)
    ttt.mark(2, 2)

    ttt.status()(0)(0) should be (X)
    ttt.status()(2)(2) should be (O)
  }

  test("players cannot mark a already marked square") {
    ttt.mark(0,0)
    evaluating { ttt.mark(0,0) } should produce [AlreadyMarkedException]
  }

  def gamePlay(theExpectedWinner: Mark, marks: (Int,Int)*) {
    test("should be able to determine that "+ theExpectedWinner +" was the winner") {
      marks.foreach(m => ttt.mark(m._1, m._2))
      ttt should be ('finished)
      ttt.winner should be (theExpectedWinner)
    }
  }

  gamePlay(X, (0,0), (1,0), (1,1), (0,1), (2,2))

  gamePlay(O, (0,2), (0,0), (1,0), (1,1), (0,1), (2,2))

}

