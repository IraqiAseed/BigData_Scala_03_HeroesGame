package util

import factory.Character

trait WeaponStrategy {
  def kick(character: Character)
}
