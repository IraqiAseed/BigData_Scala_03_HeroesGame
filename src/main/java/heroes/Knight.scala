package heroes

import scala.util.Random
import factory.Character
import util.{Sword, WeaponStrategy}

case class Knight() extends Character {
  override var power: Int = Random.between(2, 13)
  override var hitPoints: Int = Random.between(2, 13)

  val weapon: WeaponStrategy = new Sword(this)

  override def kick(enemy: Character): Unit = weapon.kick(enemy)
}
