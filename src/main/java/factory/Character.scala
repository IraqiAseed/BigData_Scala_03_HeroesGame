package factory

trait Character {
  var power: Int
  var hitPoints: Int

  def kick(c: Character)

  def isAlive(): Boolean = {
    hitPoints > 0 && power >= 0
  }

  def kill(): Unit = {
    hitPoints = 0
  }

  def decreasePower(delta: Int): Unit = {
    power -= delta
  }

  def decreaseHitPoints(delta: Int): Unit = {
    hitPoints -= delta
  }


}
