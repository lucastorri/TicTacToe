import org.scalatest.{FunSuite, BeforeAndAfterEach}
import org.scalatest.matchers.ShouldMatchers
import some.pack.{TicTacToe, Mark, InvalidSquareException, AlreadyMarkedException}
import some.pack.Mark._

class SecondTicTacToeFunSuiteTest extends FunSuite with BeforeAndAfterEach with ShouldMatchers {

  private var ttt: TicTacToe = _
  override def beforeEach() { ttt = new TicTacToe }

  test("the game should not start finished") {
    ttt should not be ('finished)
    ttt.winner should be (Mark.`_`)
  }

}

