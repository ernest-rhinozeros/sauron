package controllers

import javax.inject.{Inject, Singleton}

import play.api.Configuration
import play.api.i18n.MessagesApi
import play.api.libs.json._
import play.api.libs.ws.WSClient
import play.api.mvc.{Action, Controller}
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}

import scala.concurrent.ExecutionContext


/**
 * Created by Stephan Reinhardt on 05.08.2015.
 */
@Singleton
class Version @Inject()(override val config: Configuration,val ws: WSClient, override val messagesApi: MessagesApi,
                        val reactiveMongoApi: ReactiveMongoApi, implicit val ec: ExecutionContext) extends Controller {

  def info =  Action.async {
      val info = com.zeiss.meditec.webservice.BuildInfo
      val version = Json.obj("name" -> info.name,
        "version" -> info.version,
        "supportedApiVersions" -> Seq("v1"))
      Ok(version)
  }
}
