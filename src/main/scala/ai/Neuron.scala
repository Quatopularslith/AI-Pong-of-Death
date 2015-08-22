package ai

/**
 * Connection in brain. Makes decisions
 * Created by Torri on 8/21/2015.
 */
class Neuron(val threshold:Double) {
  val UUID = {
    Neuron.currUUID += 1
    Neuron.currUUID
  }
  private val synapses : scala.collection.mutable.MutableList[Synapse] = new scala.collection.mutable.MutableList()
  private val dendrites : scala.collection.mutable.MutableList[Synapse] = new scala.collection.mutable.MutableList()

  def addSynapse(to:Neuron, weight:Double) = {
    synapses += new Synapse(this, to, weight)
  }

  def update() = {
    var n = 0
    dendrites.filter(t => t.active).foreach(t => n += t.weight)
    if(n - threshold >= 0){
      synapses.foreach(t => t.activate)
    }
  }

  def reset() = {
    synapses.foreach(t => t.deactivate)
  }

  override def toString = {
    var out = s"($UUID:$threshold{"
    synapses.foreach(t => out += t.weight + ":" + t.to.UUID + ",")
    out + "})"
  }
}
object Neuron {
  var currUUID:Int = -1
}
