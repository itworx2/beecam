/*
 * Copyright (C) 2015 ITWorx.
 *
 * This file is part of BeeCam
 *
 * BeeCam is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BeeCam is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with BeeCam.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.beecam

import akka.actor.{Props, ActorSystem}
import spray.servlet.WebBoot

// this class is instantiated by the servlet initializer
// it needs to have a default constructor and implement
// the spray.servlet.WebBoot trait
class Boot extends WebBoot {

  // we need an ActorSystem to host our application in
  val system = ActorSystem("example")

  // the service actor replies to incoming HttpRequests
  val serviceActor = system.actorOf(Props[MyServiceActor])

}
