package heroes

import factory.Character

case class Elf() extends Character {
  override var power: Int = 10
  override var hitPoints: Int = 10

  override def kick(enemy: Character): Unit = {
    if (power > enemy.power) {
      println(s"[power: $power hp $hitPoints] Elf kicks ${enemy.getClass.getSimpleName} and kill him")
      enemy.kill()

    }
    else {
      println(s"[power: $power hp $hitPoints] Elf kicks ${enemy.getClass.getSimpleName} the damage is 1 hp")
      enemy.decreasePower(1)

    }


  }
}
