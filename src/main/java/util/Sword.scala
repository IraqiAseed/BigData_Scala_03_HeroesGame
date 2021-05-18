package util

import scala.util.Random

class Sword(hero: factory.Character) extends WeaponStrategy {

  override def kick(enemy: factory.Character): Unit = {
    val damage: Int = Random.between(0, hero.power + 1)
    val enemyName: String = enemy.getClass.getSimpleName
    val heroName: String = hero.getClass.getSimpleName
    enemy.decreaseHitPoints(damage)
    println("[power: "+hero.power+" hp "+hero.hitPoints+"] "+ heroName+" kicks "+enemyName+" damage is "+damage+" hp")

  }
}
