package factory

import org.reflections.Reflections

import scala.jdk.CollectionConverters.CollectionHasAsScala
import scala.util.Random

object CharacterFactory {

  private val scanner = new Reflections("")
  var heroesClasses: List[Class[_ <: Character]] = Nil //list of classes
  var heroesFactory: List[() => Character] = Nil // list that return new instance of classes

  def initCache(): Unit = {
    heroesClasses = scanner.getSubTypesOf(classOf[Character]).asScala.toList
    println(heroesClasses)
    createHeroesListFactory()
  }

  //solution one - normal random on list of classes
  def createCharacter(): Character = {
    val randomHero: Class[_ <: Character] = heroesClasses(Random.between(0, heroesClasses.length))
    val randomHeroInstance: Character = randomHero.getDeclaredConstructor().newInstance()
    val heroName: String = randomHeroInstance.getClass.getSimpleName
    println(s"$heroName [power ${randomHeroInstance.power} ,hit points ${randomHeroInstance.hitPoints}]")
    randomHeroInstance
  }

  //solution two - creating list with lambdas, and every element is function return instance of class
  def f(character: Class[_ <: Character]): () => Character = {
    () => character.getDeclaredConstructor().newInstance()
  }

  def createHeroesListFactory(): List[() => Character] = {
    heroesFactory = heroesClasses.map(hero => f(hero))
    heroesFactory
  }

  def createHero(): () => Character = {
    val hero = heroesFactory(Random.between(0, heroesClasses.length))
    println(s"${hero.apply().getClass.getSimpleName} [power ${hero.apply().power} ,hit points ${hero.apply().hitPoints}]")
    hero
  }

}
