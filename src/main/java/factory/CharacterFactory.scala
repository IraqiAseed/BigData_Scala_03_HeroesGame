package factory

import org.reflections.Reflections
import scala.collection.convert.ImplicitConversions.`set asScala`
import scala.util.Random

object CharacterFactory {

  private val scanner = new Reflections("")
  var heroes: List[Class[_ <: Character]] = Nil


  def initCache(): Unit = {
    heroes = scanner.getSubTypesOf(classOf[Character]).toList
    println(heroes)
  }

  def createCharacter(): Character = {
    val randomHero: Class[_ <: Character] = heroes(Random.between(0, heroes.length))
    val randomHeroInstance: Character = randomHero.getDeclaredConstructor().newInstance()
    val heroName: String = randomHeroInstance.getClass.getSimpleName
    println(s"$heroName [power ${randomHeroInstance.power} ,hit points ${randomHeroInstance.hitPoints}]")
    randomHeroInstance
  }

}
