package Heroes

import factory.Character

case class Elf() extends Character {
  override var power: Int = 10
  override var hitPoints: Int = 10

  override def kick(enemy: Character): Unit = {
    if (power > enemy.power) {
      enemy.kill()
      println(s"[power: $power hp $hitPoints] Elf kicks ${enemy.getClass.getSimpleName} and kill him")
    }
    else {
      enemy.decreasePower(1)
      println(s"[power: $power hp $hitPoints] Elf kicks ${enemy.getClass.getSimpleName} the damage is 1 hp")
    }


  }
}
