package heroes

import scala.util.Random
import factory.Character
import util.{Sword, WeaponStrategy}

case class King() extends Character {

  override var power: Int = Random.between(5, 16)
  override var hitPoints: Int = Random.between(5, 16)

  val weapon: WeaponStrategy = new Sword(this)

  override def kick(enemy: Character): Unit = weapon.kick(enemy)

}
