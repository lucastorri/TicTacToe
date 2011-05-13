import org.scalatest.{FunSuite, BeforeAndAfterEach}
import some.pack.{TicTacToe, Mark, InvalidSquareException, AlreadyMarkedException}
import some.pack.Mark._

class FirstTicTacToeFunSuiteTest extends FunSuite with BeforeAndAfterEach {

  private var ttt: TicTacToe = _
  override def beforeEach() { ttt = new TicTacToe }

  test("the game should not start finished") {
    assert(!ttt.finished)
    assert(ttt.winner === Mark.`_`)
    // _ is a reserved work in scala, so we need to scape it
  }

}
