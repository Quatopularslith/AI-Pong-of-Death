package ai

/**
 * Connection to dendrites
 * Created by Torri on 8/21/2015.
 */
class Synapse(val from:Neuron, val to:Neuron, val weight:Double) {
  var active = false
  def activate = {
    active = true
  }
  def deactivate = {
    active = false
  }
}
