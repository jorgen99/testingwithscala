package monty

import scala.util.Random
import scala.collection.mutable.ListBuffer

sealed abstract class Door
case class Car() extends Door
case class Goat() extends Door

class Game(var doors: List[Door] = Random.shuffle(List(Goat(), Goat(), Car()))) {
  var playerDoor = -1
  var montyDoor = -1
  var monty = new Monty(this)

  def chooseDoor(door: Int) = {
    playerDoor = door
    montyDoor = monty.pickDoor()
  }

  def switch() = {
    playerDoor = {
      val availableDoors = ListBuffer(0, 1, 2)
      availableDoors -= playerDoor
      availableDoors -= montyDoor
      availableDoors.head
    }
  }

  def won() = {
    doors(playerDoor) == Car()
  }
}

class Player(game: Game) {
  def chooseDoor(door: Int) = {
    game.chooseDoor(door)
  }

  def switch() = {
    //game.switch()
  }
}

class Monty(game: Game) {
  def pickDoor(): Int = {
    val availableDoors = ListBuffer(0, 1, 2)
    availableDoors -= game.playerDoor
    val montyPick = availableDoors(Random.nextInt(2))
    if (game.doors(montyPick) != Car())
      montyPick
    else
      pickDoor()
  }
}
