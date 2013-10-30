package mtfrp.client

import spray.routing.Route
import scala.virtualization.lms.common.Base
import scala.js.exp.JSExp

trait ClientSignalLib { self: BaconLibExp with JSExp with ClientEventStreamLib =>

  class ClientSignal[T: Manifest] private[client] (
      val initRoute: Option[Route],
      val exp: Exp[Property[T]]) {

    def map[A: Manifest](modifier: Rep[T] => Rep[A]): ClientSignal[A] =
      new ClientSignal(initRoute, exp.map(fun(modifier)))
  }

}