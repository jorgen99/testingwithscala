package monty

import scala.util.Random
import cuke4duke.{EN, ScalaDsl}
import org.scalatest.matchers.ShouldMatchers

class MontySteps extends ScalaDsl with EN with ShouldMatchers {

  var game:Game = _
  var player:Player = _
  
  Given("^there exists a Game$") {
    game = new Game
  }
  
  And("^there exists a Player$") {
    player = new Player(game)
  }
  
  And("""^the Doors are "(.*)"$""") { doorString:String =>
    game.doors = parseDoors(doorString)
  }
  
  When("""^the Player picks Door no (\d+)$""") { doorNo:Int =>
    player.chooseDoor(doorNo - 1)
  }
  
  When("^the Player picks a Door$") {
    When("the Player picks Door no " + (Random.nextInt(2) + 1))
    game.playerDoor should not be -1
  }

  Then("""^the Player should have picked a (\w+)$""") { door:String =>
    game.doors(game.playerDoor) should be(stringToDoor(door))
  }

  Then("""^Monty should display a (\w+)$""") { door:String =>
    game.doors(game.montyDoor) should be(stringToDoor(door))
  } 

  Then("""^Monty should pick one of (.*)$""") { doors:String =>
    val validDoors = doors.split(",").map(_.trim.toInt -1)
    validDoors.contains(game.montyDoor) should be(true)
  }

  Then("""^the Player should have (\w+)$""") { wonOrLost:String =>
    game.won should be (won(wonOrLost))
  }

  And("^the Player switches Door$") {
    player.switch
  }

  def won(s:String) = s match {
    case "Won" => true
    case "Lost" => false
  }

  def parseDoors(doorString:String) = {
    doorString.split(",").map { door =>
      stringToDoor(door.trim)
    }.toList
  }

  def stringToDoor(door:String) = door match {
    case "Car" => Car()
    case "Goat" => Goat()
    case _ => Goat()
  }

}
