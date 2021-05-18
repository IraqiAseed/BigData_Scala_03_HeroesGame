package Heroes
import factory.Character

case class Hobbit() extends Character {
  override var power: Int = 0
  override var hitPoints: Int = 3

  override def kick(enemy: Character): Unit = cry()

  def cry(): Unit = println("Cry Cry Cry !!!")
}
