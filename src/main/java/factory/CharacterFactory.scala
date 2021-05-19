package factory

import org.reflections.Reflections

import scala.jdk.CollectionConverters.CollectionHasAsScala
import scala.util.Random

object CharacterFactory {

  private val scanner = new Reflections("")
  var heroes: List[Class[_ <: Character]] = Nil //list of classes
  var heroesInstanceClasses: List[() => Character] = Nil // list that return new instance of classes

  def initCache(): Unit = {
    heroes = scanner.getSubTypesOf(classOf[Character]).asScala.toList
    println(heroes)
    createCharacterInstances()
  }

  //solution one - normal random on list of classes
  def createCharacter(): Character = {
    val randomHero: Class[_ <: Character] = heroes(Random.between(0, heroes.length))
    val randomHeroInstance: Character = randomHero.getDeclaredConstructor().newInstance()
    val heroName: String = randomHeroInstance.getClass.getSimpleName
    println(s"$heroName [power ${randomHeroInstance.power} ,hit points ${randomHeroInstance.hitPoints}]")
    randomHeroInstance
  }

  //solution two - creating list with lambdas, and every element is function return instance of class
  def f(character: Class[_ <: Character]): () => Character = {
    () => character.getDeclaredConstructor().newInstance()
  }

  def createCharacterInstances(): List[() => Character] = {
    heroesInstanceClasses = heroes.map(hero => f(hero))
    heroesInstanceClasses
  }

  def createHero(): () => Character = {
    val hero = heroesInstanceClasses(Random.between(0, heroes.length))
    println(s"${hero.apply().getClass.getSimpleName} [power ${hero.apply().power} ,hit points ${hero.apply().hitPoints}]")
    hero
  }

}
