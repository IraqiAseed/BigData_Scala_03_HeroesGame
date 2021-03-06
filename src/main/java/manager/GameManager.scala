package manager

import heroes.Hobbit
import factory.CharacterFactory

object GameManager {

  def fightWithRandomHeroes(): Unit = {
    //val h1 = CharacterFactory.createCharacter() //for solution one
    //val h2 = CharacterFactory.createCharacter() //for solution one
    val h1 = CharacterFactory.createHero().apply()
    val h2 = CharacterFactory.createHero().apply()


    if (h1.isInstanceOf[Hobbit]) {
      if (h2.isInstanceOf[Hobbit]) {
        println("equal fight .. both live")
        return
      }
    }

    while (h1.isAlive && h2.isAlive) {
      h1.kick(h2)
      if (h2.isAlive())
        h2.kick(h1)
    }

    if (h1.isAlive)
      println(h1.getClass.getSimpleName + " won")
    else
      println(h2.getClass.getSimpleName + " won")
  }

  def main(args: Array[String]): Unit = {

    CharacterFactory.initCache()
    fightWithRandomHeroes()

  }
}
